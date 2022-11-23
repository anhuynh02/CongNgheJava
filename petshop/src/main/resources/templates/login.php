<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
    <?php
    $host = 'localhost:3306';
    $dbName = 'dbAccount';
    $username = 'root';
    $password = '';
    $error = "";
    $success = "";
    $disable = "";
    $conn = new mysqli($host, $username, $password, $dbName);
    if ($conn->connect_error) {
        die("Không thể kết nối database");
    }

    $sql = 'SELECT * FROM userinfo';
    if (isset($_POST['loginBtn'])) {
        $loginun = $_POST['username'];
        $loginpw = $_POST['password'];
        $sql = "SELECT * FROM userinfo where username = '$loginun' and password = '$loginpw'";
        $result = $conn->query($sql);
        if ($result->num_rows == 0) {
            $error = "Login fail. Check your information";
        } else {
            $success = "Login successful !!!";
            //redict("Trangchu.php");
        }
    }
    if (isset($_POST['signUpBtn'])) {
        $signu = $_POST['signUsername'];
        $signp = $_POST['signPassword'];
        $signrep = $_POST['rePassword'];
        if ($signp !== $signrep) {
            die($error = "2 password fields must be the same");
        }
        $sql = "SELECT * FROM userinfo where username = '$signu'";
        $result = $conn->query($sql);
        if ($result->num_rows == 0) {
            $sql = "insert into userinfo(username,password) values(?,?)";
            $stm = $conn->prepare($sql);
            $stm->bind_param("ss", $signu, $signp);
            if(!$stm->execute()){
                $error = "System overloading !!";
            }else{
                $success = "Sign up successful. Let's login !!!";
            }
        } else {
            $error = "Trùng tên đăng nhập";
            //redict("Trangchu.php");
        }
    }
    ?>
    <script>
        $(document).ready(function() {
            $("#signUp").click(function(e) {
                $('#mySignUp').modal({
                    backdrop: 'static',
                    keyboard: false
                });
            });
        })
    </script>
    <div class="container">
        <form action="#" method="post">
            <h2>Login</h2>
            <div class="form-group">
                <label for="Username">Username:</label>
                <input class="form-control" id="username" placeholder="Enter username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
                <a href="#" id="signUp">Create new account</a>
            </div>
            <div id="checkError" class="error" style="color: red;"><?php echo $error; ?></div>
            <div id="checkError" class="success" style="color: green;"><?php echo $success; ?></div>
            <input type="submit" value="Login" name="loginBtn">

        </form>
    </div>

    <div class="modal fade" id="mySignUp" role="dialog">
        <div class="modal-dialog">
            <form action="#" method="post">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Đăng kí tài khoản</h3>
                    </div>
                    <div class="modal-body">
                        <label for="signUsername">Username:</label>
                        <input class="form-control" id="signUsername" placeholder="Enter username" name="signUsername" required>
                        <label for="signPassword">Password:</label>
                        <input type="password" class="form-control" id="signPassword" placeholder="Enter password" name="signPassword" required>
                        <label for="rePassword">Password:</label>
                        <input type="password" class="form-control" id="rePassword" placeholder="Enter password again" name="rePassword" required>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                        <input type="submit" class="btn btn-success" name="signUpBtn" value="Sign - up">
                    </div>
                </div>
            </form>
            <!-- Modal content-->
        </div>
    </div>
</body>

</html>