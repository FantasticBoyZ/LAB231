/*							
 *  Copyright(C) 2005,  FPT University							
 *  Lab Java Web:							
 *      Maria Bagnarelli's Cafe
 *							
 *  Record of change:							
 *  DATE                       Version             AUTHOR                       DESCRIPTION							
 *  2021-02-20                   1.0               TungDT                      First Implement
 */
package dao;

import entity.InformationEntity;

/**
 * This interface class used to create method to process in InformationDAOImpl
 *
 * @author Dương Thanh Tùng
 */
public interface InformationDAO {

    /**
     * This method used to get all information from database
     *
     * @return list: list of Information
     * @throws Exception
     */
    public InformationEntity getInfomation() throws Exception;
}
