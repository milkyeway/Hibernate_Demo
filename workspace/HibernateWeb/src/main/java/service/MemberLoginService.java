package service;

import model.Member;
import model.MemberDao;

public class MemberLoginService {
	private MemberDao dao;

	public MemberLoginService() {
		this.dao = new MemberDao();
	}

	public Member checkLogin(String loginName, String loginPwd) {
		Member memberBean = dao.findByNameAndPwd(loginName, loginPwd);

		if (memberBean != null) {
			return memberBean;
		}

		return null;

	}
}
