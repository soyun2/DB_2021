package Student;

import java.sql.*;
//import oracle.jdbc.*;

class CallProcedure1 {

	public void do1(){
		// TODO Auto-generated method stub
		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
       
		try {	
			int count =0;
			STUDENT[] student = new STUDENT[50];
			conn = DBConnection.getConnection();
			CallableStatement cs = conn.prepareCall("begin SEEALL(?); end;");
			cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			 // 실행
			cs.execute();
			rs = (ResultSet)cs.getObject(1);
			 
			 while(rs.next()) {
				 student[count]=new STUDENT(rs.getInt("studentno"),rs.getString("name"),rs.getString("phonenumber"),
					 rs.getString("city"),rs.getString("department"));
			 count++;
			 }
			 
			 for (int i=0;student.length>i;i++)
			 {
				if(student[i] != null)
				{
					student[i].print();
				}
			 } 
			 
			 rs.close();
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
