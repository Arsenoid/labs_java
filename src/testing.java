import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class testing {

    public static void main(String args[]) throws SQLException, IOException {
        Helper helper = new Helper();
        helper.Connection("jdbc:mysql://localhost/test", "root", "root");
        Scanner in = new Scanner(System.in);
        String tablename = "laba8_2_column";
        helper.importExcelColumnToDatabase("Urovni2_1_1_new_1_2.xlsx",tablename);
    }
}
