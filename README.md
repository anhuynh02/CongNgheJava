BCrypt: $2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy = 123<br>
Fix lỗi k tìm thấy file pom.xml:<br>
  1. Right click on the project
  2. Select menu Properties
  3. Click on Maven item in the list of left side
  4. Look at the right side and removing pom.xml from the box
  6. Apply & Close
  7. Maven -> disable maven nature
  8. Configure -> Convert to maven project
  9. Run As -> Maven clean
  10. Run As -> Maven install
