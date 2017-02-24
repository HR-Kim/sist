/**
 * 
 */
package com.khy.util;


	/**
	 * 페이징 기능 유틸 클래스
	 * 
	 * @author      james
	 * @version     1.0     2017.02.14
	 * @copyright   2017    KHL
	 *
	 * @bug
	 * @history
	*/
	public class PagingUtil
	{
	    /** 
	     *  페이징 정보를 반환한다.
	     *
	     *  @Author     bkLove(최병국)
	     *  @update
	     *  @since      2008.07.02
	     *  
	     *  @param      maxNum          총 갯수
	     *  @param      currPageNo      현재 페이지 번호
	     *  @param      rowsPerPage     한 페이지에 보여질 행수
	     *  @param      bottomCount     바닥에 보여질 페이지 수
	     *  @param      url             호출 URL
	     *  @param      scriptName      호출 스크립트
	     *  
	     *  @return     String    페이징 정보
	     */     
	    public static String renderPaging(  int     maxNum, 
	                                        int     currPageNo, 
	                                        int     rowsPerPage,
	                                        int     bottomCount,
	                                        String  url,
	                                        String  scriptName      ) 
	    {


	        int             maxPageNo   = ( (maxNum-1) / rowsPerPage ) + 1;
	        int             startPageNo = ( (currPageNo-1) / bottomCount ) * bottomCount + 1;
	        int             endPageNo   = ( (currPageNo-1) / bottomCount + 1 )*bottomCount;
	        int             nowBlockNo  = ( (currPageNo-1) / bottomCount ) + 1;
	        int             maxBlockNo  = ( (maxNum-1) / bottomCount ) + 1;
	        int             inx          = 0;
	        StringBuffer    html        = new StringBuffer();        
	        
	        if ( currPageNo > maxPageNo ) 
	        {
	            return "";
	        }
	        
	        html.append("<table border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">                                                          \n");
	        html.append("   <tr>                                                                                                                            \n");
	        html.append("       <td class=\"list_num\">                                                                                                     \n");
	        if( nowBlockNo > 1 && nowBlockNo <= maxBlockNo ) 
	        {
	            html.append("       <a href=\"javascript:" + scriptName + "( 1 );\">                                                         \n");
	            html.append("           <img src=\"/JBills/images/com/btn_prevend.gif\" width=\"17\" height=\"15\" border=\"0\" align=\"absmiddle\">        \n");
	            html.append("       </a>                                                                                                                    \n");
	        }
	        
	        if( startPageNo > bottomCount ) 
	        {
	            html.append("       <a href=\"javascript:" + scriptName + "( " + (startPageNo-1) + ");\">                                     \n");
	            html.append("           <img src=\"/JBills/images/com/btn_prev.gif\" width=\"14\" height=\"15\" border=\"0\" align=\"absmiddle\">           \n");
	            html.append("       </a>&nbsp;                                                                                                              \n");
	        }
	        
	        for( inx = startPageNo; inx <= maxPageNo && inx <= endPageNo; inx++ ) 
	        {
	            if( inx == currPageNo ) 
	            {
	                html.append("   <b>" + inx + "</b>&nbsp;&nbsp;                                                                                          \n");
	            }
	            else 
	            {
	                html.append("   <a href=\"javascript:" + scriptName + "(" + inx + ");\" class=\"num_text\">" + inx + "</a>&nbsp;&nbsp;    \n");
	            }
	        }
	        if ( maxPageNo >= inx ) 
	        {
	            html.append("       <a href=\"javascript:" + scriptName + "(" + ((nowBlockNo*bottomCount)+1) + ");\">                         \n");
	            html.append("           <img src=\"/JBills/images/com/btn_next.gif\" height=\"15\" border=\"0\" align=\"absmiddle\">                        \n");
	            html.append("       </a>                                                                                                                    \n");
	        }   
	        if ( maxPageNo >= inx ) 
	        {
	            html.append("       <a href=\"javascript:" + scriptName + "(" + maxPageNo + ");\">                                            \n");
	            html.append("           <img src=\"/JBills/images/com/btn_nextend.gif\" width=\"17\" height=\"15\" border=\"0\" align=\"absmiddle\">        \n");
	            html.append("       </a>                                                                                                                    \n");
	        }        
	        html.append("       </td>                                                                                                                       \n");        
	        html.append("   </tr>                                                                                                                           \n");
	        html.append("</table>                                                                                                                           \n");
	        
	        
	        return html.toString();
	    }
	}
