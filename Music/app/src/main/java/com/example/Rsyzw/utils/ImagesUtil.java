package com.example.Rsyzw.utils;

import java.util.ArrayList;
import java.util.Random;

public class ImagesUtil {

    private static ArrayList<String> images;

    public static String getImagesUrl(int size){
        images = new ArrayList<>();
        images.add("https://images.nowcoder.com/images/20170909/4107856_1504933721660_43CAE73DE2EF35F43C1CBA030B1CF5E0?x-oss-process=image/resize,m_mfit,h_100,w_100");
        images.add("https://images.nowcoder.com/images/20191105/999991341_1572923480661_47C81A001EB84E8A9F2015F21CC31AED?x-oss-process=image/resize,m_mfit,h_100,w_100");
        images.add("https://images.nowcoder.com/images/20190729/999991364_1564385956032_2BA333085C9987DA6E4EE0C8D96B02B2?x-oss-process=image/resize,m_mfit,h_100,w_100");
        images.add("https://images.nowcoder.com/images/20190926/999991356_1569483579393_294C47304E8AB5C2F85E87BC90681526?x-oss-process=image/resize,m_mfit,h_100,w_100");
        images.add("https://images.nowcoder.com/images/20190314/92286570_1552534617601_605475850F555A9A1D76953CFB3E39A6?x-oss-process=image/resize,m_mfit,h_100,w_100");
        images.add("https://images.nowcoder.com/images/20190312/195593609_1552354102825_605475850F555A9A1D76953CFB3E39A6?x-oss-process=image/resize,m_mfit,h_100,w_100");
        images.add("https://images.nowcoder.com/images/20190906/999991354_1567736520318_5792FBE40575717F4AD1F580CB6206BF?x-oss-process=image/resize,m_mfit,h_100,w_100");
        images.add("https://images.nowcoder.com/images/20190309/38457461_1552127330605_605475850F555A9A1D76953CFB3E39A6?x-oss-process=image/resize,m_mfit,h_100,w_100");
        images.add("https://images.nowcoder.com/images/20191015/226473669_1571152869877_F0666DCEA1E731869E6782CB61E0C63E?x-oss-process=image/resize,m_mfit,h_100,w_100");
        images.add("https://images.nowcoder.com/images/20190226/94458911_1551194513275_605475850F555A9A1D76953CFB3E39A6?x-oss-process=image/resize,m_mfit,h_100,w_100");
        return images.get(new Random().nextInt(size));
    }

    public static ArrayList<String> getBitMapUrl(){
        //设置图片资源:url或本地资源
        images = new ArrayList<>();
        images.add("http://p1.music.126.net/FIPbxHCUx7l_74GeRHlpxg==/109951164500559810.jpg?imageView&quality=89");
        images.add("http://p1.music.126.net/2yh7rSB7vmJH06cr4GWAIg==/109951164500585257.jpg?imageView&quality=89");
        images.add("http://p1.music.126.net/NzC8PPWR4SQbbm3bz9YsNw==/109951164500600171.jpg?imageView&quality=89");
        images.add("http://p1.music.126.net/KRlazN4B32tTXH2CuQobGA==/109951164500608286.jpg?imageView&quality=89");
        images.add("http://p1.music.126.net/NpCSnFurqZEulkdB7nT-8g==/109951164501657967.jpg?imageView&quality=89");
        images.add("http://p1.music.126.net/LAQvfszxItqNJRrgeGt6Xw==/109951164500598472.jpg?imageView&quality=89");
        images.add("http://p1.music.126.net/bmHJ82ycAb5caTYaW17G_w==/109951164501236134.jpg?imageView&quality=89");
//        images.add("https://img3.mukewang.com/szimg/5959a60f0001cfd305400300-360-202.jpg");
//        images.add("https://img2.mukewang.com/szimg/59118b92000147bf05400300-360-202.jpg");
//        images.add("https://img1.mukewang.com/szimg/59313618000198ed05400300-360-202.jpg");
//        images.add("https://img1.mukewang.com/szimg/59eeb022000162bc05400300-360-202.jpg");
//        images.add("https://img4.mukewang.com/szimg/59eeb17200013f8605400300-360-202.jpg");
//        images.add("https://img1.mukewang.com/szimg/5d43953c09c0247612000676-360-202.png");
//        images.add("https://climg.mukewang.com/5c8097e80001960406000338-280-160.jpg");
        return images;
    }

    public static ArrayList<String> getBitMapTitleUrl(){
        //设置图片标题:自动对应
        images = new ArrayList<>();
        images.add("虽然文学都没有所谓的正确答案，但在有限的解读中自由度最大的便是诗。\n" +
                "\n" +
                "只要包含作家的真情，诗歌可以适用于任何形式的内容。");
        images.add("人气乐队RADWIMPS最新EP——《天気の子 complete version》将于11月27日（星期三）在网易云音乐与日本地区同步上线！");
        images.add("无论是高兴，是悲伤，是愤怒，是彷徨，只要切到这个，任何版本都能让我耐下心听一会，哪怕一分钟，都能让我平静下来。一两百年过去了，这就是古典的力量，巴赫的力量。");
        images.add("世界上所有美好事物，都值得多看两眼。与美好事物相邻，活着就是幸福。但是美好事物是需要等待的’ 所以尽管我们都是个焦虑小怪兽 但还是要对未来充满希望。");
        images.add("不管多苦多难多累，多痛，我都可以承受，我愿意承受，因为爱了就是爱了，没有任何借口。");
        images.add("《我爱你，这是最好的安排》是由上海润金文化传播有限公司出品大型青春偶像剧，张彬彬、郑合惠子、高洋、孔舒航等主演。");
        images.add("片寄凉太配音动画电影《若与你共乘海浪之上》主题曲《Brand New Story》、描绘坚持追求梦想的《DREAMERS》、与EXPG STUDIO后辈们共享梦想并一起前进的《EXPerience Greatness》、炒热演唱会气氛的舞曲《F.L.Y. BOYS F.L.Y. GIRLS》、献给10年前自己的中板抒情曲《少年》等等");
        return images;
    }

}
