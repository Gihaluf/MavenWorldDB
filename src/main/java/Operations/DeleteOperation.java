package Operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteOperation {

    public static int deleteRecord(Connection con, String tableName,
                                   String pkColumn, String pkValue)
            throws SQLException {
    	if(tableName == "countrylanguage") {
    		String sql = "DELETE FROM countrylanguage "
                    + "WHERE CountryCode = ? AND Language = ?";
    		try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, countryCode);
                ps.setString(2, language);
                return ps.executeUpdate();
            }
        }else {
	        String sql = "DELETE FROM " + tableName
	                   + " WHERE " + pkColumn + " = ?";
	        try (PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setString(1, pkValue);
	            return ps.executeUpdate();
	        }
        }
        
        
        
    }

}