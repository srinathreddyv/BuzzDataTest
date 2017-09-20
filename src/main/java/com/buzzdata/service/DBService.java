package com.buzzdata.service;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.buzzdata.domain.DBConnection;
import com.buzzdata.model.Enrollment;

@Component
public class DBService {

	public void insertData(Enrollment enr) throws ClassNotFoundException,
			URISyntaxException, SQLException {
		// TODO Auto-generated method stub

		Connection con = null;

		con = DBConnection.getConnection();

		String insertQuery = "INSERT INTO ENROLLMENT(ID, USERID, COURSEID, ROLEID, DOMAINID, GUID, "
				+ "PRIVILIGES, STATUS, STARTDATE, ENDDATE, FLAGS, FIRSTACTIVITYDATE, LASTACTIVITYDATE, "
				+ "CREATIONDATE, CREATIONBY, MODIFIEDDATE, MODIFIEDBY, VERSION, REFERENCE)"
				+ "VALUES" + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement preparedStatement = null;

		preparedStatement = con.prepareStatement(insertQuery);
		preparedStatement.setString(1, enr.getId());
		preparedStatement.setString(2, enr.getUserid());
		preparedStatement.setString(3, enr.getCourseid());
		preparedStatement.setString(4, enr.getRoleid());
		preparedStatement.setString(5, enr.getDomainid());
		preparedStatement.setString(6, enr.getGuid());
		preparedStatement.setString(7, enr.getPrivileges());
		preparedStatement.setString(8, enr.getStatus());
		preparedStatement.setString(9, enr.getStartdate());
		preparedStatement.setString(10, enr.getEnddate());
		preparedStatement.setString(11, enr.getFlags());
		preparedStatement.setString(12, enr.getFirstactivitydate());
		preparedStatement.setString(13, enr.getLastactivitydate());
		preparedStatement.setString(14, enr.getCreationdate());
		preparedStatement.setString(15, enr.getCreationby());
		preparedStatement.setString(16, enr.getModifieddate());
		preparedStatement.setString(17, enr.getModifiedby());
		preparedStatement.setString(18, enr.getVersion());
		preparedStatement.setString(19, enr.getReference());

		preparedStatement.executeUpdate();

		con.close();
	}
	
	public List<String> getDetails() throws ClassNotFoundException, URISyntaxException, SQLException{
		Connection con = null;
		List<String> idList = new ArrayList<>();
		con = DBConnection.getConnection();
		
		String query = "SELECT * FROM ENROLLMENT";
		
		PreparedStatement preparedStatement = null;

		preparedStatement = con.prepareStatement(query);
		
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			String id = rs.getString("ID");
			idList.add(id);
		}
		con.close();
		
		return idList;
	}
}
