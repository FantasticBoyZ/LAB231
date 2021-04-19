/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Photographer	
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               KhoiVT                      First Implement
 */
package dao;

import entity.Contact;

/**
 * This interface class contain some method used to implements in another class
 *
 * @author Vu Tien Khoi
 */
public interface ContactDAO {

    /**
     * This method used to get all contact from database
     *
     * @return Contact <code>Object</code>
     * @throws Exception
     */
    public Contact getContact() throws Exception;
}
