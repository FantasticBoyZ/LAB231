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

import entity.Image;
import java.util.List;

/**
 * This interface class contain some method used to implements in another class
 *
 * @author Vu Tien Khoi
 */
public interface ImageDAO {

    /**
     * This method used to count total number of image with id input
     *
     * @param id <code>Integer</code> id of Gallery input
     * @return count <code>Integer</code> number of image
     * @throws Exception
     */
    public int countImage(int id) throws Exception;

    /**
     * This method used to get url of image with id input
     *
     * @param id <code>Integer</code> id of Gallery input
     * @return url <code>String</code> url of image
     * @throws Exception
     */
    public List<Image> getImageByGaleryID(int id) throws Exception;

    /**
     * This method used to get list of image with paging
     *
     * @param galeryID <code>Integer</code> id of gallery input
     * @param pageIndex <code>Integer</code> index of first gallery in list
     * @param pageSize <code>Integer</code> number of gallery in 1 page
     * @return list: List of Image
     * @throws Exception
     */
    public List<Image> getListImageWithPaging(int galeryID, int pageIndex, int pageSize) throws Exception;

    /**
     * This method used to get image by Gallery Id and Image Id
     *
     * @param id <code>Integer</code> Gallery Id input
     * @param galeryId <code>Integer</code> Image Id
     * @return Image <code>Object</code>
     * @throws Exception
     */
    public Image getImageID(int id, int galeryId) throws Exception;

    /**
     * This method used to get Image by Gallery ID
     *
     * @param galeryID <code>Integer</code> Image Id
     * @return Image <code>Object</code>
     * @throws Exception
     */
    public Image getTopImageGalery(int galeryID) throws Exception;
}
