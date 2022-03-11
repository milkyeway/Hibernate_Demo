package service;

import java.util.List;

import model.CompanyBean;

public interface CompanyServiceInterface {

	CompanyBean select(int comId);

	List<CompanyBean> selectAll();

	Boolean delete(int comId);

	CompanyBean insert(CompanyBean comBean);

	CompanyBean updateOne(int comId, String comName);
}
