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

import entity.CakeEntity;
import java.util.List;

/**
 * This interface class used to create method to process in CakeDaoImpl
 *
 * @author Dương Thanh Tùng
 */
public interface CakeDAO {

    /**
     * This method used to get product from database
     *
     * @return list: List of Cake
     * @throws Exception
     */
    public List<CakeEntity> getTop2() throws Exception;

    /**
     * This method used to get Cake with cake id matched with id input
     *
     * @param CakeID <code>Integer</code>
     * @return list: List of Cake
     * @throws Exception
     */
    public CakeEntity getCakeDetail(int CakeID) throws Exception;

    /**
     * This method used to get total product in database
     *
     * @return count: Number of product
     * @throws Exception
     */
    public int getTotalProducts() throws Exception;

    /**
     * This method used to get all Cake and pagination
     *
     * @param pageIndex <code>Integer</code>
     * @param pageSize <code>Integer</code>
     * @return list: List of Cake
     * @throws Exception
     */
    public List<CakeEntity> getAllCakes(int pageIndex, int pageSize) throws Exception;

}
