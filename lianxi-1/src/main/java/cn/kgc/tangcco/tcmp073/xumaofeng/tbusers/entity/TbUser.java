package cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class TbUser {
	
	private int userid;
	@NonNull
	private String username,password;
	private String userroles,nickname;
	private String email,tel;
	private Date rgtime;
	public TbUser(String username, String password, String userroles, String nickname, String email, String tel,
			Date rgtime) {
		super();
		this.username = username;
		this.password = password;
		this.userroles = userroles;
		this.nickname = nickname;
		this.email = email;
		this.tel = tel;
		this.rgtime = rgtime;
	}
	
	
	
}
