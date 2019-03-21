package cn.kgc.tangcco.tcmp073.xumaofeng.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class TbUser {
	
	private Integer userid;
	@NonNull
	private String username,password;
	
	private String userroles,nickname;
}
