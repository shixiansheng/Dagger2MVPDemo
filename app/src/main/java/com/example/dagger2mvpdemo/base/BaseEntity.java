package com.example.dagger2mvpdemo.base;

import java.util.List;

/**
 * @author 时志邦
 * @CreateDate 2018/3/28 22:39
 * @Description: ${TODO}(用一句话描述该文件做什么)
 */

public class BaseEntity<T> {

    /**
     * Code : 200
     * Msg :
     * Data : [{"newsID":"A921721650580","title":"得瑟得瑟4","imageUrl":"http://www.infoacq.com/files/images/436760688950/images/201802/20180225102.jpg","type":1},{"newsID":"A921721650580","title":"得瑟得瑟3","imageUrl":"http://www.infoacq.com/files/images/436760688950/images/201802/20180225102.jpg","type":1},{"newsID":"A921721650580","title":"得瑟得瑟1","imageUrl":"http://www.infoacq.com/files/images/436760688950/images/201802/20180225102.jpg","type":1},{"newsID":"A921721650580","title":"得瑟得瑟","imageUrl":"http://www.infoacq.com/files/images/436760688950/images/201802/20180225102.jpg","type":1}]
     */

    public String Code;
    public String Msg;
    public  T Data;


}
