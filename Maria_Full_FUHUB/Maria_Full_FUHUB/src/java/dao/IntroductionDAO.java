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

import entity.IntroductionEntity;

/**
 * This interface class used to create method to process in IntroductionDAOImpl
 *
 * @author Dương Thanh Tùng
 */
public interface IntroductionDAO {

    /**
     * This method used to get all Introduction from database
     *
     * @return @throws Exception
     */
    public IntroductionEntity getIntroduction() throws Exception;
}
