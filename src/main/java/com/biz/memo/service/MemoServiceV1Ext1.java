package com.biz.memo.service;

import java.util.List;

import com.biz.memo.persistence.MemoDTO;

public class MemoServiceV1Ext1 extends MemoServiceV1 {

	@Override
	protected void selectAll() {
		// TODO Auto-generated method stub
		List<MemoDTO> memoList = memoDao.selectAll();
		if(memoList.size() < 1) {
			System.out.println("검색 결과가 없습니다");
			return;
		}
		this.showList(memoList);
	}
	
	@Override
	protected void findById() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("글번호 >> ");
			String str_id = scan.nextLine();
			if(str_id.equalsIgnoreCase("-Q")) return;
			long id = 0;
			try {
				id = Long.valueOf(str_id);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("글번호는 숫자로 입력해주세요");
			}
			MemoDTO memoDTO = memoDao.findById(id);
			if(memoDTO == null) {
				System.out.println("검색 결과가 없습니다");
				return;
			}
			this.showDTO(memoDTO);
			break;
		}
	}

	@Override
	protected void findByAuth() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("작성자 >> ");
			String m_auth = scan.nextLine();
			if(m_auth.equalsIgnoreCase("-Q")) return;
			List<MemoDTO> memoList = memoDao.findByAuth(m_auth);
			if(memoList.size() < 1) {
				System.out.println("검색 결과가 없습니다");
				return;
			}
			this.showList(memoList);
			break;
		}
	}

	@Override
	protected void findBySubject() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("제목 >> ");
			String m_subject = scan.nextLine();
			if(m_subject.equalsIgnoreCase("-Q")) return;
			List<MemoDTO> memoList = memoDao.findBySubject(m_subject);
			if(memoList.size() < 1) {
				System.out.println("검색 결과가 없습니다");
				return;
			}
			this.showList(memoList);
			break;
		}
	}

	@Override
	protected void findByText() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("내용 >> ");
			String m_text = scan.nextLine();
			if(m_text.equalsIgnoreCase("-Q")) return;
			List<MemoDTO> memoList = memoDao.findByText(m_text);
			if(memoList.size() < 1) {
				System.out.println("검색 결과가 없습니다");
				return;
			}
			this.showList(memoList);
			break;
		}
	}

	@Override
	protected void findByDate() {
		// TODO Auto-generated method stub
		while(true) {
			String m_date1 = "";
			while(true) {
				System.out.print("시작날짜 >> ");
				m_date1 = scan.nextLine();
				if(m_date1.equalsIgnoreCase("-Q")) return;
				if(!this.dateCheck(m_date1)) {
					System.out.println("날짜 형식이 잘못되었습니다 다시 입력해주세요 (예: 2019-01-01 또는 2019-1-1)");
					continue;
				}
				break;
			}
			
			String m_date2 = "";
			while(true) {
				System.out.print("마지막날짜 >> ");
				m_date2 = scan.nextLine();
				if(m_date2.equalsIgnoreCase("-Q")) return;
				if(!this.dateCheck(m_date2)) {
					System.out.println("날짜 형식이 잘못되었습니다 다시 입력해주세요 (예: 2019-01-01 또는 2019-1-1)");
					continue;
				}
				break;
			}
			
			List<MemoDTO> memoList = memoDao.findByDate(m_date1, m_date2);
			if(memoList.size() < 1) {
				System.out.println("검색 결과가 없습니다");
				return;
			}
			this.showList(memoList);
			break;
		}
	}
	
	

}
