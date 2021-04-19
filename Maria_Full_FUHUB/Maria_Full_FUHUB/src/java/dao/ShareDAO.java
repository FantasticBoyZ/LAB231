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

import entity.ShareEntity;
import java.util.List;

/**
 * This interface class used to create method to process in ShareDAOImpl
 *
 * @author Dương Thanh Tùng
 */
public interface ShareDAO {

    /**
     * This method used to get all Share from database
     *
     * @return list: List of Share
     * @throws Exception
     */
    public List<ShareEntity> getShare() throws Exception;
}
