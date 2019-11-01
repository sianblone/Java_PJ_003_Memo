package com.biz.memo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.biz.memo.mybatis.DBConnection;
import com.biz.memo.mybatis.dao.MemoDao;
import com.biz.memo.persistence.MemoDTO;

public class MemoServiceV1 {
	
	protected MemoDao memoDao;
	protected Scanner scan;
	
	public MemoServiceV1() {
		// TODO Auto-generated constructor stub
		memoDao = DBConnection.getSqlSessionFactory().openSession(true).getMapper(MemoDao.class);
		scan = new Scanner(System.in);
	}
	
	public void memoMenu() {
		while(true) {
			System.out.println("=====================================================");
			System.out.println("개인 메모장");
			System.out.println("=====================================================");
			System.out.println("1.검색  2.작성  3.수정  4.삭제  0.종료");
			System.out.print(">>");
			String getScan = scan.nextLine();
			if(getScan.equals("1")) {
				System.out.println("----------------------검색-----------------------");
				System.out.println("(-Q를 입력하면 입력을 중단할 수 있습니다)");
				this.search(getScan);
			} else if(getScan.equals("2")) {
				System.out.println("----------------------작성-----------------------");
				System.out.println("(-Q를 입력하면 입력을 중단할 수 있습니다)");
				this.insert();
			} else if(getScan.equals("3")) {
				System.out.println("----------------------수정-----------------------");
				System.out.println("(아무 것도 입력하지 않고 Enter를 누르면 기존 내용이 그대로 유지됩니다)");
				System.out.println("(-Q를 입력하면 입력을 중단할 수 있습니다)");
				this.update();
			} else if(getScan.equals("4")) {
				System.out.println("----------------------삭제-----------------------");
				System.out.println("(-Q를 입력하면 입력을 중단할 수 있습니다)");
				this.delete();
			} else if(getScan.equals("0")) {
				System.out.println("서비스를 종료합니다");
				return;
			}
		}
		
	}
	
	protected void search(String getScan) {
		while(true) {
			System.out.println("1.전체  2.작성자  3.제목  4.내용  5.날짜  0.뒤로");
			System.out.print(">>");
			getScan = scan.nextLine();
			if(getScan.equals("1")) {
				this.selectAll();
			} else if(getScan.equals("2")) {
				this.findByAuth();
			} else if(getScan.equals("3")) {
				this.findBySubject();
			} else if(getScan.equals("4")) {
				this.findByText();
			} else if(getScan.equals("5")) {
				this.findByDate();
			} else if(getScan.equals("0")) {
				return;
			}
		}
	}

	protected void selectAll() {
		// TODO Auto-generated method stub
		
	}
	
	protected void findById() {
		
	}

	protected void findByAuth() {
		// TODO Auto-generated method stub
		
	}

	protected void findBySubject() {
		// TODO Auto-generated method stub
		
	}

	protected void findByText() {
		// TODO Auto-generated method stub
		
	}

	protected void findByDate() {
		// TODO Auto-generated method stub
		
	}

	protected void insert() {
		// TODO Auto-generated method stub
		
	}

	protected void update() {
		// TODO Auto-generated method stub
		
	}

	protected void delete() {
		// TODO Auto-generated method stub
		
	}
	
	protected void showList(List<MemoDTO> memoList) {
		for(MemoDTO memoDTO : memoList) {
			System.out.println("글번호\t제목\t내용\t작성자\t작성일자");
			System.out.println("--------------------------------------------------------------------");
			System.out.print(memoDTO.getId() + "\t");
			System.out.print(memoDTO.getM_subject() + "\t");
			System.out.print(memoDTO.getM_text() + "\t");
			System.out.print(memoDTO.getM_auth() + "\t");
			System.out.print(memoDTO.getM_date() + "\n");
		}
	}
	
	protected void showDTO(MemoDTO memoDTO) {
		System.out.println("----------------------------------------------------------");
		System.out.println("제목:" + memoDTO.getM_subject());
		System.out.println("내용:" + memoDTO.getM_text());
		System.out.println("작성자:" + memoDTO.getM_auth());
		System.out.println("작성일자" + memoDTO.getM_date());
		System.out.println("----------------------------------------------------------");
	}
	
	protected void compareUpdate(MemoDTO oldMemoDTO, MemoDTO newMemoDTO) {
		System.out.println("----------------------------------------------------------");
		System.out.println("제목:" + oldMemoDTO.getM_subject() + " -> " + newMemoDTO.getM_subject());
		System.out.println("내용:" + oldMemoDTO.getM_text() + " -> " + newMemoDTO.getM_text());
		System.out.println("작성자:" + oldMemoDTO.getM_auth() + " -> " + newMemoDTO.getM_auth());
		System.out.println("작성일자" + oldMemoDTO.getM_date() + " -> " + newMemoDTO.getM_date());
		System.out.println("----------------------------------------------------------");
	}
	
	protected boolean dateCheck(String date) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		sd.setLenient(false);
		try {
			sd.parse(date);
			return true;
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			return false;
		}
	}
}
