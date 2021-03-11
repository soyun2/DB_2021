package Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class CallProcedure4 {

	public void do4() {
		// TODO Auto-generated method stub
		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
		try {
			
			Scanner scan = new Scanner(System.in);
			System.out.println("삭제할 학생번호 입력 : ");
			int stnum = scan.nextInt();
//			scan.close();
			
//			STUDENT[] student = new STUDENT[50];
			conn = DBConnection.getConnection();
			 // 프로시저 호출
			 CallableStatement cs = conn.prepareCall("begin del_student(?); end;");
			 // 입력 파라메터
			 cs.setInt(1, stnum);
			 int seq= cs.executeUpdate();			 
			 if ( seq ==0 )
			 {
				 System.out.println(seq+"값");
			 }
			 else
			 {
				 System.out.println(seq+"값");
			 }
			 
//			 rs.close();
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
