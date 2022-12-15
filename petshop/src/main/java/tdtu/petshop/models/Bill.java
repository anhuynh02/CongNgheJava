package tdtu.petshop.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@Column(columnDefinition = "int default 0")
	private int total;
//	@Column(columnDefinition = "boolean default false")
	private boolean purchased;
	public int getId() {
		return id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
	
	public Bill() {
		super();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isPurchased() {
		return purchased;
	}

	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", total=" + total + ", purchased=" + purchased + ", user=" + user + "]";
	}
	
}