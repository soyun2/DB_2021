package Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class CallProcedure2 {

	public void do2() {
		// TODO Auto-generated method stub
		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
        
        System.out.println("=====학생 정보 수정=====");
        Scanner scan = new Scanner(System.in);
        System.out.println("수정할 학생 번호 : ");
        int stnu = scan.nextInt();
        scan.nextLine();
        System.out.println("학생 이름: ");
        String stna = scan.nextLine();
        System.out.println("학생 전화번호: ");
        String stphone = scan.nextLine();
        System.out.println("학생 고향: ");
        String stcity = scan.nextLine();
        System.out.println("학생 전공: ");
        String stdep = scan.nextLine();
//        scan.close();         
        
		try {	
//			int count =0;
//			STUDENT[] student = new STUDENT[50];
			conn = DBConnection.getConnection();
			 // 프로시저 호출
			 CallableStatement cs = conn.prepareCall("begin update_student(?,?,?,?,?); end;");
			 // 입력 파라메터
			 cs.setInt(1, stnu); //따옴표 없이 값 대입
			 cs.setString(2, stna); //따옴표 가지고 값 대입
			 cs.setString(3, stphone);
			 cs.setString(4, stcity);
			 cs.setString(5, stdep);
			 int seq= cs.executeUpdate();
			 
			 if ( seq ==0 )
			 {
				 System.out.println(seq+"값");
			 }
			 else
			 {
				 System.out.println(seq+"값");
			 }

			 cs.close();
			 conn.close();
			 } catch(Exception e){
			 e.printStackTrace();
			 }
		finally{
            // DB 연결을 종료한다.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
	}

}
