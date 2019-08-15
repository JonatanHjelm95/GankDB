/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author jonab
 */
public class TimestampToDate {

    public static Date convert(Timestamp time) {
        Date date = new Date(time.getTime());
        return date;
    }

}
