/*
Navicat MySQL Data Transfer

Source Server         : 47.104.76.77
Source Server Version : 50721
Source Host           : 47.104.76.77:3306
Source Database       : happy_reader

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-02-27 20:50:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '书籍id',
  `bookName` varchar(255) DEFAULT NULL COMMENT '书名',
  `bookType` int(11) DEFAULT NULL COMMENT '书籍类别id',
  `author` varchar(255) DEFAULT '' COMMENT '作者',
  `brief` varchar(500) DEFAULT '',
  `pages` int(11) DEFAULT NULL COMMENT '页数',
  `path` varchar(255) DEFAULT '' COMMENT '路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8688 DEFAULT CHARSET=utf8mb4;


INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('1', '1973年的弹子球', '13', '村上春树', '    我们再次陷入沉默。我把燃到头的香烟', '31', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\1973年的弹子球_村上春树.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('2', '1984', '13', '乔治·奥威尔', '	    据说，真理部在地面上有三千间屋子，和地面下的结构相等。在伦敦别的地方，还有三所其他的建筑，外表和大小与此相同。它们使周围的建筑仿佛小巫见了大巫，因此你从胜利大厦的屋顶上可以同时看到这四所建筑。它们是整个政府机构四部的所在地：真理部负责新闻、娱乐、教育、艺术；和平部负责战争；友爱部维持法律和秩序；富裕部负责经济事务。', '88', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\1984_乔治·奥威尔.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('3', '1Q84BOOK2', '13', '村上春树', '“这金鱼是为阿翼买的。”老夫人望着青豆的脸，解释道，“麻布的商店街在举办小小的庙会，我就带着阿翼去那儿散步。心想一直闷在房间里对她的身体不好。', '80', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\1Q84BOOK2_村上春树.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('4', '1Q84BOOK3', '13', '村上春树', '\"叫了一个名叫青豆的年轻女人来酒店的套房，给领袖做肌肉的拉伸复健。在九月初，市中心电闪雷鸣下着暴雨的那个', '103', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\1Q84BOOK3_村上春树.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('5', '1Q84', '13', '村上春树', '青豆点点头，重新靠回椅背上。司机的说法中有什麼引起她的注意。经常把重要事情保留一件没说似的说法。例如(只是举例)对t', '92', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\1Q84_村上春树.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('6', 'PRINCE CASPIAN', '13', 'C·S·刘易斯', 'edmund and lucy es  and it begins to be cold.”', '39', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\PRINCE CASPIAN_C·S·刘易斯.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('7', 'Sabriel (The Abhorsen Trilogy)', '13', '加斯·尼克斯', 'he could hear the child crying, which was good', '105', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\Sabriel (The Abhorsen Trilogy)_加斯·尼克斯.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('8', 'The Horse and His Boy', '13', 'C·S·刘易斯', 'and then for a second he thought he ing, for quite distinctly,  though in a low voic', '42', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\The Horse and His Boy_C·S·刘易斯.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('9', 'The Last Battle', '13', 'C·S·刘易斯', '\"dont you start getting ideas into your head, puzzle,\" said shi', '38', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\The Last Battle_C·S·刘易斯.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('10', 'The Lion, the Witch and the War', '13', 'C·S·刘易斯', 'the umbrella: in the other arm he carried several broas  shopping. he was a faun. and when he saw lucy he gave such a start of surprise that he  dropped all his parcels.', '34', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\The Lion, the Witch and the War_C·S·刘易斯.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('11', 'THE SILVER CHAIR', '13', 'C·S·刘易斯', '\"i know i do,\" said jill.', '46', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\THE SILVER CHAIR_C·S·刘易斯.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('12', 'THE VOYAGE OF THE DAWN TREADER', '13', 'C·S·刘易斯', '\"oving. and the water looks as if it was really wet. and the waves look as  if they were really going up and down.”', '45', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\THE VOYAGE OF THE DAWN TREADER_C·S·刘易斯.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('13', '一个人的好天气', '13', '青山七惠', '话越来越少了，开始感觉不自在时，她离开了房间', '28', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\一个人的好天气_青山七惠.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('14', '一个人的遭遇', '13', '米哈依尔·肖洛霍夫', '	　　那父亲除下干瘪的背囊，懒洋洋地在我身旁坐下来说：“带着这种客人真倒霉：他简直把我累坏啦。你的步子迈得大一点，他就得跑步了。嘿，要迁就这种步兵真伤脑筋。一步路得分三步走，可这样他还是跟不上我，就像乌龟跟不上马一样。可', '14', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\一个人的遭遇_米哈依尔·肖洛霍夫.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('15', '一个女人一生中的24小时', '13', '斯蒂芬·茨威格', '	    不过，这也只是就他的形体来说罢了，因为，所有的饭桌上异口同声都在谈论着他，都在啧啧称道', '24', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\一个女人一生中的24小时_斯蒂芬·茨威格.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('16', '一个陌生女人的来信', '13', '斯蒂芬·茨威格', '我要把我整个的一生都向你倾诉，我这一生实在说起来是我认识你的那一天才开始的。在这以前，我的生活只是阴惨惨、乱糟糟的一团，我再也不会想起它来，它就象是一个地窖，堆满了尘封霉湿的人和物，上面还结着蛛网，对于这些，我的心早已非常淡漠。你在我生活出现的时候，我十三岁，就住在你现在住的那幢房子里，此刻你就在这幢房子里，手里拿着这封信，我生命的最后一息。我和你住在同一层楼，正好门对着门。你肯定再也想不起我们，想不起那个寒酸的会计员的寡妇（她总是穿着孝服）和她那尚未长成的瘦小的女儿--我们深居简出，不声不响，仿', '15', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\一个陌生女人的来信_斯蒂芬·茨威格.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('17', '一九八四', '13', '乔治·奥威尔', '那爱护部着实叫人怕。整座大楼根本就没有窗户。温斯顿从来没进过爱护部，连半公里之内也没到过。除非公干，谁也别想进去；即便进得去，也必得先穿过迷宫似', '88', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\一九八四_乔治·奥威尔.txt');
INSERT INTO `happy_reader`.`t_book` (`id`, `bookName`, `bookType`, `author`, `brief`, `pages`, `path`) VALUES ('18', '一件事先张扬的凶杀案', '13', '加西亚·马尔克斯', '	    我在她的回忆中看到了圣地亚哥．纳赛尔。在一月份的最后一个礼拜', '29', 'D:\\小说网站数据\\处理后\\小说天堂\\世界名著\\一件事先张扬的凶杀案_加西亚·马尔克斯.txt');
