package com.biz.memo.service;

import java.time.LocalDate;

import com.biz.memo.persistence.MemoDTO;

public class MemoServiceV1Ext2 extends MemoServiceV1Ext1 {

	@Override
	protected void insert() {
		// TODO Auto-generated method stub
		System.out.print("제목 >> ");
		String m_subject = scan.nextLine();
		if(m_subject.equalsIgnoreCase("-Q")) return;
		
		System.out.print("내용 >> ");
		String m_text = scan.nextLine();
		if(m_text.equalsIgnoreCase("-Q")) return;
		
		String m_auth = "";
		while(true) {
			System.out.print("작성자 >> ");
			m_auth = scan.nextLine();
			if(m_auth.equalsIgnoreCase("-Q")) return;
			if(m_auth.isEmpty()) {
				System.out.println("작성자명을 입력해주세요");
				continue;
			}
			break;
		}
		
		LocalDate local = LocalDate.now();
		String m_date = local.toString();
		
		MemoDTO memoDTO = MemoDTO.builder()
				.m_subject(m_subject)
				.m_text(m_text)
				.m_auth(m_auth)
				.m_date(m_date)
				.build();
		
		this.showDTO(memoDTO);
		
		while(true) {
			System.out.print("작성하시겠습니까?(y/n) >> ");
			String yn = scan.nextLine();
			if(yn.equalsIgnoreCase("y")) {
				if(memoDao.insert(memoDTO) > 0) {
					System.out.println("작성 완료");
				} else {
					System.out.println("작성 실패");
				}
			} else if(yn.equalsIgnoreCase("n")) {
				System.out.println("작성 취소");
			} else {
				continue;
			}
			break;
		}
		
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		long id = 0;
		while(true) {
			System.out.print("수정할 글번호 >> ");
			String str_id = scan.nextLine();
			if(str_id.equalsIgnoreCase("-Q")) return;
			try {
				id = Long.valueOf(str_id);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("글번호는 숫자로 입력해주세요");
				continue;
			}
			break;
		}
		MemoDTO oldMemoDTO = memoDao.findById(id);
		if(oldMemoDTO == null) {
			System.out.println("글이 존재하지 않습니다");
			return;
		}
		
		System.out.print("제목 >> ");
		String m_subject = scan.nextLine();
		if(m_subject.equalsIgnoreCase("-Q")) return;
		if(m_subject.isEmpty()) {
			m_subject = oldMemoDTO.getM_subject();
		}
		
		System.out.print("내용 >> ");
		String m_text = scan.nextLine();
		if(m_text.equalsIgnoreCase("-Q")) return;
		if(m_text.isEmpty()) {
			m_text = oldMemoDTO.getM_text();
		}
		
		String m_auth = "";
		while(true) {
			System.out.print("작성자 >> ");
			m_auth = scan.nextLine();
			if(m_auth.equalsIgnoreCase("-Q")) return;
			if(m_auth.isEmpty()) {
				System.out.println("작성자명을 입력해주세요");
				continue;
			}
			break;
		}
		
		MemoDTO newMemoDTO = MemoDTO.builder()
				.id(oldMemoDTO.getId())
				.m_subject(m_subject)
				.m_text(m_text)
				.m_auth(m_auth)
				.m_date(oldMemoDTO.getM_date())
				.build();
		
		this.compareUpdate(oldMemoDTO, newMemoDTO);
		
		while(true) {
			System.out.print("이대로 수정하시겠습니까?(y/n) >> ");
			String yn = scan.nextLine();
			if(yn.equalsIgnoreCase("y")) {
				if(memoDao.update(newMemoDTO) > 0) {
					System.out.println("수정 완료");
				} else {
					System.out.println("수정 실패");
				}
			} else if(yn.equalsIgnoreCase("n")) {
				System.out.println("수정 취소");
			} else {
				continue;
			}
			break;
		}
		
	}

	@Override
	protected void delete() {
		// TODO Auto-generated method stub
		long id = 0;
		while(true) {
			System.out.print("삭제할 글번호 >> ");
			String str_id = scan.nextLine();
			if(str_id.equalsIgnoreCase("-Q")) return;
			try {
				id = Long.valueOf(str_id);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("글번호는 숫자로 입력해주세요");
				continue;
			}
			break;
		}
		MemoDTO memoDTO = memoDao.findById(id);
		if(memoDTO == null) {
			System.out.println("글이 존재하지 않습니다");
			return;
		}
		
		this.showDTO(memoDTO);
		while(true) {
			System.out.print("정말로 삭제하시겠습니까?(y/n) >> ");
			String yn = scan.nextLine();
			if(yn.equalsIgnoreCase("y")) {
				if(memoDao.delete(id) > 0) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패");
				}
			} else if(yn.equalsIgnoreCase("n")) {
				System.out.println("삭제 취소");
			} else {
				continue;
			}
			break;
		}
		
	}

}
