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

import entity.Galery;
import java.util.List;

/**
 * This interface class contain some method used to implements in another class
 *
 * @author Vu Tien Khoi
 */
public interface GaleryDAO {

    /**
     * This method used to get top 3 Gallery from database
     *
     * @param topNumber <code>Integer</code>
     * @return list: List of Gallery
     * @throws Exception
     */
    public List<Galery> getTopGalery(int topNumber) throws Exception;

    /**
     * This method used to get Gallery by id input
     *
     * @param index <code>Integer</code>
     * @param id <code>Integer</code>
     * @return Gallery <code>Object</code>
     * @throws Exception
     */
    public Galery getGaleryByID( int id) throws Exception;

    /**
     * This method used to count total number of Gallery
     *
     * @return count <code>Integer</code> number of gallery
     * @throws Exception
     */
    public int count() throws Exception;

    /**
     * This method used to get list of Gallery with Paging
     *
     * @param pageIndex <code>Integer</code> index of first gallery in list
     * @param pageSize <code>Integer</code> number of gallery in 1 page
     * @return list: List of Gallery
     * @throws Exception
     */
    public List<Galery> getListGaleryWithPaging(int pageIndex, int pageSize) throws Exception;
}
