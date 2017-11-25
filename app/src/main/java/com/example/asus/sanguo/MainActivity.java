package com.example.asus.sanguo;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private List<Map<String, Object>> clist;
    private List<Map<String, Object>> slist;
    private CharacterListViewAdapter cadapter;
    private SkillListViewAdapter sadapter;
    private ListView mCharacterList;
    private ListView mSkillList;
    private Button CSChange;
    private Button mCharacterListAdd;
    private Button mSkillListAdd;
    private Button mLittletest;
    private ImageButton searchButton;
    private EditText msearch;
    private AlertDialog mcdialog;
    private AlertDialog msdialog;
    Intent intent;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCharacterList = findViewById(R.id.characterlist);
        mSkillList = findViewById(R.id.skilllist);
        mCharacterListAdd = findViewById(R.id.characterlistadd);
        mSkillListAdd = findViewById(R.id.skilllistadd);
        mLittletest = findViewById(R.id.littletestgoto);
        CSChange = findViewById(R.id.characterskillchange);
        TextInputLayout characterlistsearch = findViewById(R.id.characterlistsearch);
        searchButton = findViewById(R.id.characterlistsearchButton);
        msearch = characterlistsearch.getEditText();
        msearch.clearFocus();
        msearch.setSelected(false);
        if (CharacterDataBase.getInstances(MainActivity.this).query().getCount() == 0){
            CharacterDataBase.getInstances(MainActivity.this).insert("zhaoyun", "赵云(子龙)","lancer","男","158","228","常山真定","蜀汉","    身长八尺，姿颜雄伟，蜀汉五虎上将之一。\n    汉末军阀混战，赵云受本郡推举，率领义从加入白马将军公孙瓒。期间结识了汉室皇亲刘备，但不久之后，因为兄长去世而离开。赵云离开公孙瓒大约七年左右的时间，在邺城与刘备相见，从此追随刘备。","A","B","A+","A","EX","EX");
            CharacterDataBase.getInstances(MainActivity.this).insert("sunshangxiang", "孙尚香","archer","女","0","0","吴郡富春","吴","    孙夫人，乃孙权之妹，名曰孙仁。刘备向东吴借荆州不还，周瑜上书孙权，教使“美人计”，进妹予刘备为夫人，不料在诸葛亮的锦囊妙计安排下，假婚成真姻；后来夫人更助刘备返蜀，于路上怒斥追袭的吴将。后刘备入益州，孙权闻知刘备西征，遣周善引领舟船以迎孙夫人，而夫人带着后主刘禅回吴，幸得赵云与张飞勒兵截江，方重夺刘禅。\n    彝陵之战，刘备战败，有讹言传入吴中，道刘备已死，孙夫人伤心不已，望西痛哭，投江而死。后人为其立庙，号曰“枭姬祠”。","C","D","A+","C","A++","B");
            CharacterDataBase.getInstances(MainActivity.this).insert("huangyueying", "黄月英","caster","女","0","0","沔南白水","蜀汉","    黄承彦之女,有传闻说她容貌甚丑却知识广博。也有传闻说其极美，故意令黄承彦提亲时说自己貌丑以试探孔明心意。\n  黄月英十分擅长机关术，曾制木虎、木犬、木人等物，无需人力操控即可自动。诸葛亮发明木牛流马，据说也是从黄月英的传授的技巧上发展出来的。","E","D","D","A++","A","A+");
            CharacterDataBase.getInstances(MainActivity.this).insert("caiwenji", "蔡琰(文姬)","caster","女","0","0","陈留圉县","魏","    东汉大文学家蔡邕的女儿。初嫁于卫仲道，丈夫死去而回到自己家里，后值因匈奴入侵，蔡琰被匈奴左贤王掳走，嫁给匈奴人，并生育了两个孩子。十二年后，曹操统一北方，用重金将蔡琰赎回，并将其嫁给董祀。","E","C","E","B","E","EX");
            CharacterDataBase.getInstances(MainActivity.this).insert("diaochan", "貂蝉","assassin","女","0","0","未知","群","    中国古代四大美女之一，因遭十常侍之乱，避难出宫，为司徒王允收留为歌女。董卓祸乱朝纲，残忍暴戾，貂蝉挺身而出离间董卓和他的义子吕布，最终铲除了权倾一时的董卓。","D","D","B","B","A+","EX");
            CharacterDataBase.getInstances(MainActivity.this).insert("zhenfu", "甄宓","caster","女","183","221","中山无极","魏","    文昭甄皇后，上蔡令甄逸之女。魏文帝曹丕的正室，魏明帝曹叡的生母。初嫁与袁熙，袁氏败亡后，被曹丕纳为己有。\n    甄氏风华绝代，曹植以《洛神赋》赞之。","D","C","C","EX","C","A");
            CharacterDataBase.getInstances(MainActivity.this).insert("caocao", "曹操(孟德)","saber","男","155","220","沛国谯县","魏","    东汉末年，曹操以汉天子的名义征讨四方，统一了中国北方，并实行一系列政策恢复经济生产和社会秩序，使中原社会渐趋稳定、经济出现转机。 \n    精通兵法，重贤爱才，诗歌气魄雄伟，慷慨悲凉；散文亦清峻整洁，开启并繁荣了建安文学。","C","C","D","C","A++","EX");
            CharacterDataBase.getInstances(MainActivity.this).insert("lvbu", "吕布(奉先)","berserker","男","0","198","五原九原","群","    原为丁原部将，被唆使杀害丁原归附董卓，与董卓誓为父子，后又被司徒王允唆使诛杀董卓。 兴平元年，吕布趁曹操攻打陶谦时与陈宫等叛乱，先后击败刘备与夏侯惇。曹操亲自出马征讨吕布，水淹下邳，吕布被部下叛变，城破被俘，被处死。\n    历史上吕布以勇武闻名，号称“飞将”，时有“人中吕布，马中赤兔”之说。","A+","A+","A","C","C","A+");
            CharacterDataBase.getInstances(MainActivity.this).insert("zhugeliang", "诸葛亮(孔明)","caster","男","181","234","琅琊阳都","蜀汉","    早年随叔父诸葛玄到荆州，诸葛玄死后，诸葛亮就在隆中耕种。后刘备三顾茅庐请出，辅佐刘备建立蜀汉。蜀汉建立后，诸葛亮被封为丞相、武乡侯，内抚百姓，对外联吴抗魏，为实现兴复汉室的政治理想，数次北伐，但最终失败，最后病逝于五丈原。","D","D","C","A+++","B","EX");
            CharacterDataBase.getInstances(MainActivity.this).insert("zhouyu", "周瑜(公瑾)","rider","男","175","210","庐江舒","吴","    长壮有姿貌、精音律，江东有“曲有误，周郎顾”之语。\n     少与孙策交好，21岁起随孙策奔赴战场平定江东，后孙策遇刺身亡，孙权继任，周瑜将兵赴丧，以中护军的身份与长史张昭共掌众事。建安十三年，率军与刘备联合，于赤壁之战中大败曹军，由此奠定了“三分天下”的基础。","C","D","B","A","B","EX");
        }
        if (SkillDataBase.getInstances(MainActivity.this).query().getCount() == 0){
            SkillDataBase.getInstances(MainActivity.this).insert("赵云(子龙)","职阶技能", "对魔力", "B", "较高的对魔力，可以毫不困难地无效化三节以下的魔术，即使是大魔术、仪礼咒法也难以给予其伤害。");
            SkillDataBase.getInstances(MainActivity.this).insert("赵云(子龙)","职阶技能", "骑乘", "B", "由于“骑士”本来就是擅长马上战斗的军人，所以骑乘等级非常高。");
            SkillDataBase.getInstances(MainActivity.this).insert("赵云(子龙)","固有技能", "千里护主之骑", "A+", "当自身存在于Master远处，Master遇到危险时，可以不消耗令咒的力量将其呼唤到其主身边。同时，在通过这个技能召唤出现之时，赵云的全属性在一定时间内会上升一个等级。");
            SkillDataBase.getInstances(MainActivity.this).insert("赵云(子龙)","固有技能", "千军之将七进七出", "EX", "此技能为赵云最有名的事迹‘长坂坡之战’的具现。赵云的运气属性会根据敌人的数量成正比例提升。若对拥有此技能的赵云，使用人海战术，无疑是找死般的行为。");
            SkillDataBase.getInstances(MainActivity.this).insert("赵云(子龙)","固有技能", "心眼（真）", "A", "在修行与锻炼中得到的洞察力和战斗理论。纵然是绝境，都可以冷静走出扭转形势的一步。");
            SkillDataBase.getInstances(MainActivity.this).insert("赵云(子龙)","固有技能", "龙胆", "A", "无效化精神干涉的能力。并且有使格斗伤害上升的效果。");
            SkillDataBase.getInstances(MainActivity.this).insert("赵云(子龙)","固有技能", "无穷之武练", "A+++", "在过去某个时代的盖世无双的武艺.由于将心、技、体完全融合为一,不管在何种精神制约下都能将自身的战斗能力完美发挥。");
            SkillDataBase.getInstances(MainActivity.this).insert("赵云(子龙)","宝具", "涯角枪", "A+", "枪身乃混铁精钢打造而成，带盘龙雕文，坚固而带韧性，枪头乃白金铸就，寒光凛凛，锋锐无比，上书“天涯海角无对”。为常胜将军赵云的佩枪，只有其本人才能发挥出此枪的潜在威力。\n    藉由将所有者的灵气变换成焰，再从往下挥的枪的前端如大爆炸一般地放出来破坏万物。");
            SkillDataBase.getInstances(MainActivity.this).insert("赵云(子龙)","宝具", "青釭剑", "A", "三国时代的霸主之一曹操所铸造的神兵，故有“云乃拔青虹剑乱砍，手起处，衣甲平过，血如涌泉”的描述，被赵云所得，助其在战场上大放异彩。\n    拥有“破甲”的效果，能够对防具，结界等造成大幅度的损伤。");
            SkillDataBase.getInstances(MainActivity.this).insert("赵云(子龙)","宝具", "枪技·百鸟朝凤", "A+++", "是赵云的老师——枪法宗师童渊所创的一种枪法，幻化出百鸟之影，最终身化凤凰，百虚而一实的致命一击。无法被格挡或者闪避。");
            SkillDataBase.getInstances(MainActivity.this).insert("孙尚香","职阶技能", "对魔力", "C", "能将咏唱少于两节的魔术无效化，但无法防御大魔术、仪式咒法等大规模魔术。");
            SkillDataBase.getInstances(MainActivity.this).insert("孙尚香","职阶技能", "单独行动", "B", "失去master后，可以2日间持续一直现界。不过这是避免战斗和使用宝具等所带来的消耗、尽可能保存魔力的情况下的理想值。");
            SkillDataBase.getInstances(MainActivity.this).insert("孙尚香","固有技能", "枭姬", "B", "孙尚香有着与传统女性截然不同的桀骜不驯的个性，刚强勇猛，技艺过人，在战斗时能够激发出更进一步的力量和技巧，同时能大幅强化孙尚香的视力和命中力。");
            SkillDataBase.getInstances(MainActivity.this).insert("孙尚香","固有技能", "猛虎", "C", "孙尚香流淌着孙家的猛虎之血，在战斗中容易进入狂战状态，以失去理智为代价获得更高的出力，同时能够放出火焰属性的魔力。");
            SkillDataBase.getInstances(MainActivity.this).insert("孙尚香","宝具", "红莲弓", "B", "缠绕着火焰的弓，能释放出火属性的箭矢，当真名解放后便如同炮台一般，能够射出如同导弹一般威力的攻击。");
            SkillDataBase.getInstances(MainActivity.this).insert("孙尚香","宝具", "天命的结合", "A++", "作为两国友好合作的象征，孙尚香作为联姻的对象远嫁蜀汉。\n   该宝具发动后能够大幅的强化目标和我方的各能力值，并且完全恢复损伤。不过孙尚香本人似乎非常不满这样的命运。");
            SkillDataBase.getInstances(MainActivity.this).insert("黄月英","职阶技能", "阵地作成", "B", "作为魔术师，造出对自己有利的阵地。B等级只能够作出“工房”而不是“神殿”");
            SkillDataBase.getInstances(MainActivity.this).insert("黄月英","职阶技能", "道具作成", "EX", "制作带有魔力的器具。被称为“工神”的她能够制作出超越时代的魔术造物和机关傀儡");
            SkillDataBase.getInstances(MainActivity.this).insert("黄月英","固有技能", "天赋的奇才", "EX", "黄月英是绝世奇才，任何知识、技巧和魔术都能轻易的习得，即使是现代科学的技术也轻易完全掌握了的程度，英雄个人技能以及肉体上的负荷以外的技能都能发挥出A级甚至以上的熟练度。");
            SkillDataBase.getInstances(MainActivity.this).insert("黄月英","固有技能", "奇门遁甲", "A", "熟读兵书，上知天文，下知地理，文韬武略，足智多谋，尤其擅长玄门数算，奇门遁甲之术，能够有限的计算未来，同时在风水构建，阵地作成方面也无可匹及。");
            SkillDataBase.getInstances(MainActivity.this).insert("黄月英","宝具", "工神的无限机巧秘库", "EX", "储藏着黄月英无数作品的宝库，拥有包括“连弩”、“木牛流马”、“机巧傀儡”等各种各样超越时代的黑科技发明——然而在黄月英眼里这些大概都是失败品吧。为了追求超越人类的造物黄月英仍然在努力中，正因如此，这座名为宝库实为垃圾堆的仓库库存依旧在不断的增加。");
            SkillDataBase.getInstances(MainActivity.this).insert("黄月英","宝具", "石兵八阵", "B", "侵入这巨石构成的大阵之人会被就此迷惑，并被迫入死亡。原本是某位军师的宝具，实际上是由黄月英的父亲所教——作为女儿的黄月英实际上也掌握着这样的技巧，但是看起来这大概只是她无聊时候的顺手之作吧。");
            SkillDataBase.getInstances(MainActivity.this).insert("蔡琰(文姬)","职阶技能", "阵地作成", "B", "作为魔术师，造出对自己有利的阵地。B等级只能够作出“工房”而不是“神殿”");
            SkillDataBase.getInstances(MainActivity.this).insert("蔡琰(文姬)","职阶技能", "道具作成", "B", "以魔术来创造出各种道具的能力。虽然不懂魔术，但无比的才气应用宝具而写成的诗词文章，也能够进行制作。");
            SkillDataBase.getInstances(MainActivity.this).insert("蔡琰(文姬)","固有技能", "艺术审美", "A", "蔡琰博览群书，对艺术作品、文学作品拥有无比的执着心。目睹在艺术界与文学界有着相关传说的宝具时，可以看破其真名。");
            SkillDataBase.getInstances(MainActivity.this).insert("蔡琰(文姬)","固有技能", "过目不忘", "A", "“博闻强识，不辱才女之名。”，蔡琰拥有过目不忘的才能，只要看过一遍的东西就能完全的记忆并且复刻下来——无论是怎样的魔术，或者A级以下的技能，只要目睹，即使不知道原理也可以完美的复制并且使用。");
            SkillDataBase.getInstances(MainActivity.this).insert("蔡琰(文姬)","固有技能", "音乐神的加护", "EX", "能听到并理解所有的声音，使天才般的演奏成为可能，更甚的是，可以将音乐魔术的行使加强补正，这些效果可以作为“自身之力”被发挥出来。");
            SkillDataBase.getInstances(MainActivity.this).insert("蔡琰(文姬)","宝具", "一曲悲歌愁断肠", "A+", "感念自身以及天下万民悲惨的命运所作的一曲，名为《胡笳十八拍》的旷世杰作——使得听闻之人感受到命运的残酷与无情，永远的徘徊在苦难之中直至死亡,是能够撬动命运因果之弦的乐曲。");
            SkillDataBase.getInstances(MainActivity.this).insert("蔡琰(文姬)","宝具", "焦尾琴", "C", "父亲留给蔡琰的名琴，能够奏出超出演奏者水平的声音，用于行使音乐魔术时使魔术等级增加一级。");
            SkillDataBase.getInstances(MainActivity.this).insert("貂蝉","职阶技能", "屏蔽气息", "B", "断绝作为Servant的气息。适合于隐密行动。当自己转移至攻击姿态时，屏蔽气息的等级会大幅下降。");
            SkillDataBase.getInstances(MainActivity.this).insert("貂蝉","固有技能", "连环之谋", "B", "如何将对象暗杀的战术思考。与军略不同，只能应用在少数的暗杀计。使用该技能能够推演未来的方式布置计划，只有足够高等级的幸运才能对抗该技能。");
            SkillDataBase.getInstances(MainActivity.this).insert("貂蝉","固有技能", "魅惑的容颜", "EX", "拥有足以闭月的美貌，这份美貌在“美人计”的传说中被升华为超越神魔的魅惑力——只要是异性，无论怎样的请求都能够答应这样的等级，但对于貂蝉本人来说同样是一份枷锁吧，拥有如此美貌的她要怎样才能找到真正爱着她的人呢？");
            SkillDataBase.getInstances(MainActivity.this).insert("貂蝉","固有技能", "离间", "C", "实际上是超出常规的精神暗示与干扰的技巧，不知不觉间干扰对方的思维使其互相之间产生强烈的敌意，配合貂蝉倾世的舞技甚至能让整个军队自相残杀。");
            SkillDataBase.getInstances(MainActivity.this).insert("貂蝉","固有技能", "舞之真意", "A", "虽然也擅长音乐，但是舞蹈才是貂蝉真正的传世之技。华丽的舞姿甚至能够沟通天地，相当于仪式一般的产生大型魔术的效果。");
            SkillDataBase.getInstances(MainActivity.this).insert("貂蝉","宝具", "一舞倾城·再舞倾国", "A++", "终极的舞技与魅力的结合，貂蝉舞的最终奥义。动人的舞姿之下整个城市的人都会头脑麻痹，成为被貂蝉的傀儡，就连精神耐受不足的从者也无法抵御。实际上，这段舞蹈的第二段从未被展现过。");
            SkillDataBase.getInstances(MainActivity.this).insert("甄宓","职阶技能", "阵地作成", "EX", "本身并不能制作阵地，但是只要有水的地方就是她的主场，拥有相当于“神殿”的效果，而处于洛水之中时的她几乎无所不能。");
            SkillDataBase.getInstances(MainActivity.this).insert("甄宓","职阶技能", "道具作成", "B", "以魔术来创造出各种道具的能力。虽然魔术能力不足，但是借由水可以完成各种不可思议的魔术造物");
            SkillDataBase.getInstances(MainActivity.this).insert("甄宓","固有技能", "美的显现", "A++", "“翩若惊鸿，婉若游龙。荣曜秋菊，华茂春松。”曹植是这么描述她的美丽的。拥有卓绝魅力，吸引他人的能力。虽然足以与貂蝉媲美，但是由于并没有美色祸乱世间的传说，所以并没有超越人与神的范畴");
            SkillDataBase.getInstances(MainActivity.this).insert("甄宓","固有技能", "女神的神核", "EX", "作为与生俱来就是完成型的女神代表性的技能。是包含了神性的复合技能。维持着肉体和精神的绝对性。不会受到精神干涉，肉体也不会成长变化。");
            SkillDataBase.getInstances(MainActivity.this).insert("甄宓","固有技能", "洛水之神", "EX", "是掌控水与冰的绝对力量，只要是液体就能够随意操控的魔法级别的权能。");
            SkillDataBase.getInstances(MainActivity.this).insert("甄宓","宝具", "河图洛书", "EX", "是五行八卦数术的起源，也是能够操控风水，预知未来的终极宝具，因为产生于洛水的传说而成为了甄宓的宝具。");
            SkillDataBase.getInstances(MainActivity.this).insert("甄宓","宝具", "芳泽无加，铅华弗御", "C", "C级以下的攻击和诅咒无法对甄宓产生效果。");
            SkillDataBase.getInstances(MainActivity.this).insert("甄宓","宝具", "凌波微步，罗袜生尘", "B", "内按九宫八卦，十分飘逸的步法，使用后敏捷力大幅提升，同时难以被命中。");
            SkillDataBase.getInstances(MainActivity.this).insert("甄宓","宝具", "洛水清波，沐浴人心", "EX", "固有结界，借由洛神的权能召唤而来的洛河的具象化。由于哺育了中华文明的缘故，洛河拥有远超一般河流的幻想的力量，立于洛水之上的洛神无可匹敌。");
            SkillDataBase.getInstances(MainActivity.this).insert("曹操(孟德)","职阶技能", "对魔力", "C", "无效化以二工程以下咏唱引起的魔术。不能防御大魔术、礼仪咒法等，大规模的魔术。");
            SkillDataBase.getInstances(MainActivity.this).insert("曹操(孟德)","职阶技能", "骑乘", "B", "能够灵活驾驭较为优秀的坐骑和交通工具，但不能驾驭神兽、圣兽及龙。");
            SkillDataBase.getInstances(MainActivity.this).insert("曹操(孟德)","固有技能", "领导力", "A", "指挥军团的天生才能，A级的领导力足以建立世界级的大帝国，但是由于多为英杰的阻拦，曹操的这个野望最终还是未能成功。");
            SkillDataBase.getInstances(MainActivity.this).insert("曹操(孟德)","固有技能", "军略", "A", "多数人参加的战斗中的战术上的直感力。使用对军宝具，应对对手的对军宝具时获得正，曹操高超军事才能的体现。");
            SkillDataBase.getInstances(MainActivity.this).insert("曹操(孟德)","固有技能", "皇帝特权", "A", "本来不能持有的技能，也可以因为本人的主张而能在短时间内获得。符合的技能是骑乘、剑术、艺术、统率力、谋略等。等级是A以上的情况下，连肉体层面的负荷（神性等）也能获得。虽然生前并没有称帝，但是千古威名和魏武帝的称呼还是令他拥有了这个技能。");
            SkillDataBase.getInstances(MainActivity.this).insert("曹操(孟德)","固有技能", "鉴识眼", "A", "对于观察对象的人类将来会获得何种形式的可用性这一点，有着十分卓 越的眼力，曹操唯才是举政策的保证。");
            SkillDataBase.getInstances(MainActivity.this).insert("曹操(孟德)","宝具", "短歌行", "B", "曹操在文学方面也有着无上的才能，《短歌行》就是他才华的终极体现。能够增加我方的士气与能力数值。");
            SkillDataBase.getInstances(MainActivity.this).insert("曹操(孟德)","宝具", "倚天剑", "A", "三国时代的霸主之一曹操所铸造的两把神兵之一，拥有“破甲”的效果，能够对防具，结界等造成大幅度的损伤。另一把交付给了夏侯恩，最后被赵云所夺取。");
            SkillDataBase.getInstances(MainActivity.this).insert("曹操(孟德)","宝具", "绝影", "B", "曹操生前所乘坐的名马，曾多次带着曹操逃离险情，影子都跟不上的绝世好马。");
            SkillDataBase.getInstances(MainActivity.this).insert("曹操(孟德)","宝具", "孟德新书", "C", "曹操所作的兵书，能够使使军略一类的技能增加一个等级。");
            SkillDataBase.getInstances(MainActivity.this).insert("曹操(孟德)","宝具", "铜雀台", "EX", "固有结界，是曹操与麾下文武共同构筑的时代神话。能够暂时召唤出曹操麾下的奇谋良将，其中不乏“郭嘉”、“典韦”等强大的从者存在。");
            SkillDataBase.getInstances(MainActivity.this).insert("吕布(奉先)","职阶技能", "狂化", "A", "让参数等级提升，但夺去大部份理性。由于被强行与Master的战斗意识进行连结，所以变成了较机械性的Servant。");
            SkillDataBase.getInstances(MainActivity.this).insert("吕布(奉先)","固有技能", "无穷之武练", "A+++", "在过去某个时代的盖世无双的武艺.由于将心、技、体完全融合为一,不管在何种精神制约下都能将自身的战斗能力完美发挥。");
            SkillDataBase.getInstances(MainActivity.this).insert("吕布(奉先)","固有技能", "反骨之相", "B", "不会逗留在同一个地方，也不会拥戴同一个君主的天性。不适合亲自当君主，亦无法找到自己君主的流浪之星。将相同等级的「领导力」无效化。");
            SkillDataBase.getInstances(MainActivity.this).insert("吕布(奉先)","固有技能", "鬼神", "A++", "鬼神般的怪力，使自身的筋力提高。效力几近顶级，其力量和巨人已是别无二致。");
            SkillDataBase.getInstances(MainActivity.this).insert("吕布(奉先)","宝具", "赤兔", "B", "“人中吕布，马中赤兔”，赤兔乃是马中之王，拥有无匹的速度和力量，与吕布心意相通，二者加在一起时战力倍增。");
            SkillDataBase.getInstances(MainActivity.this).insert("吕布(奉先)","宝具", "军神五兵", "A", "作为吕布奉先的主武器而广为人知的双手武器方天画戟的真名。能够变形成六个形态的多重兵器。就像是吕布一个人持有六名Servant的宝具一样。");
            SkillDataBase.getInstances(MainActivity.this).insert("诸葛亮(孔明)","职阶技能", "阵地作成", "A", "以魔术师的身份，创造出对自己有利的阵地。能做成远在「工房」之上的「石兵八阵」。");
            SkillDataBase.getInstances(MainActivity.this).insert("诸葛亮(孔明)","职阶技能", "道具作成", "B", "能制作诸葛孔明生前所有的、如连弩等众多效果多样的武具和道具。然而实际上多是黄月英所发明的造物。");
            SkillDataBase.getInstances(MainActivity.this).insert("诸葛亮(孔明)","固有技能", "军师的忠言", "A+", "军师系Servant的技能。能对战况进行分析，并给予对我方形势有用的建议。等级越高准确性越高。等级A+的情况下可以把意外事态在内、进行100%预测。若要对抗此技能，需要拥有非常强大的幸运。");
            SkillDataBase.getInstances(MainActivity.this).insert("诸葛亮(孔明)","固有技能", "军师的指挥", "A+", "军师系Servant的技能，把包括自己在内的兵士最大力量发挥出来。等级A+的情况，能让士兵使出逼近“做好了死的觉悟”程度的实力。");
            SkillDataBase.getInstances(MainActivity.this).insert("诸葛亮(孔明)","固有技能", "奇门遁甲", "B", "黄承彦所教授的玄门数算，奇门遁甲之术，能够有限的推演未来，改变风水，甚至能够逆天改命。");
            SkillDataBase.getInstances(MainActivity.this).insert("诸葛亮(孔明)","宝具", "续命七星灯", "B", "命不久矣时布下的续命法门，成功后便能逆转死亡的逆天数术，但是对于幸运属性有着苛刻的要求，A级以下就几乎不可能成功，即使是A级的幸运也有着一半的可能失败");
            SkillDataBase.getInstances(MainActivity.this).insert("诸葛亮(孔明)","宝具", "石兵八阵", "B", "本军的败退不可避免之际布下的阵势。侵入这巨石构成的大阵之人会被就此迷惑，并被迫入死亡。\n    作为宝具则是将对方位处的场所强制改换为石兵八阵的大魔术。只要没有脱离石兵八阵，作为目标的众人每回合受到的追加伤害就会一直累积下去。");
            SkillDataBase.getInstances(MainActivity.this).insert("诸葛亮(孔明)","宝具", "出师表", "EX", "诸葛孔明在编制讨伐敌国的军队时，为时年尚幼的皇帝留下的奏表。能够大幅度的增加我方的士气与能力数值");
            SkillDataBase.getInstances(MainActivity.this).insert("周瑜(公瑾)","职阶技能", "骑乘", "B", "能够灵活驾驭较为优秀的坐骑和交通工具，但不能驾驭神兽、圣兽及龙。");
            SkillDataBase.getInstances(MainActivity.this).insert("周瑜(公瑾)","职阶技能", "对魔力", "B", "较高的对魔力，可以毫不困难地无效化三节以下的魔术，即使是大魔术、仪礼咒法也难以给予其伤害。");
            SkillDataBase.getInstances(MainActivity.this).insert("周瑜(公瑾)","固有技能", "暴风航海者", "A", "驱使被理解为船的东西的才能。由于也需要作为集团领袖的能力，所以也兼备了军事谋略、统率力效果的特殊技能。");
            SkillDataBase.getInstances(MainActivity.this).insert("周瑜(公瑾)","固有技能", "艺术审美", "C", "“曲有误，周郎顾”，目睹在艺术界有着相关传说的宝具时，可以看破其真名。");
            SkillDataBase.getInstances(MainActivity.this).insert("周瑜(公瑾)","固有技能", "红颜美少年", "C", "作为吸引他人的美少年的性质。发动时是对男女都有效果的魅惑魔术，但只要对方有反抗的意思的话效果就会减弱。拥有对魔力技能的话完全回避也是可能的。");
            SkillDataBase.getInstances(MainActivity.this).insert("周瑜(公瑾)","固有技能", "军师的忠言", "A", "军师系Servant的技能。能对战况进行分析，并给予对我方形势有用的建议。等级越高准确性越高。");
            SkillDataBase.getInstances(MainActivity.this).insert("周瑜(公瑾)","宝具", "楼船之阵", "B", "周瑜所率领的东吴水师，只要在水上就能够无敌的军队，拥有强大的作战的能力。即使是日常也会召唤出一艘楼船作为座驾。");
            SkillDataBase.getInstances(MainActivity.this).insert("周瑜(公瑾)","宝具", "赤壁之业炎", "EX", "曾经一口气燃尽七十万大军的红莲业火，是将魏武帝击下神坛的火焰。即使是神明也不敢面对这缭绕着无尽冤魂的大火。作为释放的代价，周瑜会进入持续的虚弱状态。");

        }
        List<Map<String, Object>> data = getCharacterData("");
        cadapter = new CharacterListViewAdapter(this, data);
        mCharacterList.setAdapter(cadapter);
        mCharacterList.setTextFilterEnabled(true);
        cadapter.notifyDataSetChanged();

        List<Map<String, Object>> data1 = getSkillData("");
        sadapter = new SkillListViewAdapter(this, data1);
        mSkillList.setVisibility(View.INVISIBLE);
        mSkillList.setAdapter(sadapter);
        mSkillList.setTextFilterEnabled(true);
        sadapter.notifyDataSetChanged();

        CSChange.setTag("0");
        setListener();

        intent = new Intent(MainActivity.this,MusicService.class);
        startService(intent);

    }


    private void setListener() {

        CSChange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (CSChange.getTag() == "0"){
                    CSChange.setBackgroundResource(R.mipmap.skillpng);
                    CSChange.setTag("1");
                    mSkillList.setVisibility(View.VISIBLE);
                    mCharacterList.setVisibility(View.INVISIBLE);
                } else {
                    CSChange.setBackgroundResource(R.mipmap.characterpng);
                    CSChange.setTag("0");
                    mSkillList.setVisibility(View.INVISIBLE);
                    mCharacterList.setVisibility(View.VISIBLE);
                }
            }
        });
        
        //搜索按钮
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String search = msearch.getText().toString().trim();
                List<Map<String, Object>> data1 = getCharacterData(search);
                List<Map<String, Object>> data2 = getSkillData(search);
                cadapter.refreshList(data1);
                sadapter.refreshList(data2);
            }
        });

        //点击跳转英灵增加
        mCharacterListAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CharacterAdd.class);
                startActivityForResult(intent, 0);
            }
        });

        //点击跳转宝具增加
        mSkillListAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SkillAdd.class);
                startActivityForResult(intent, 0);
            }
        });

        //点击跳转小测试
        mLittletest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LittleTest.class);
                startActivityForResult(intent, 0);
            }
        });
        //英灵list的监听事件
        mCharacterList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            private int id;
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
//                //删除是要拿到当前行的id值才能删除当前行,下面的操作都是点击某个item拿到对应item的id字段
//                //拿到当前position的 item的所有数据
                Object id = clist.get(position).get("id");
                int i = Integer.parseInt(id.toString());
                String image = clist.get(position).get("image").toString();
                String name = clist.get(position).get("name").toString();
                String job = clist.get(position).get("job").toString();
                String sex = clist.get(position).get("sex").toString();
                String birth = clist.get(position).get("birth").toString();
                String death = clist.get(position).get("death").toString();
                String origo = clist.get(position).get("origo").toString();
                String army = clist.get(position).get("army").toString();
                String introduction = clist.get(position).get("introduction").toString();
                String stre = clist.get(position).get("stre").toString();
                String endu = clist.get(position).get("endu").toString();
                String agil = clist.get(position).get("agil").toString();
                String magi = clist.get(position).get("magi").toString();
                String luck = clist.get(position).get("luck").toString();
                String skil = clist.get(position).get("skil").toString();

                //将得到id传入到需要的方法中
                showCharacterDialog(i, image, name, job, sex, birth, death, origo, army ,introduction, stre, endu, agil, magi, luck, skil);
                return true;
            }
        });

        mCharacterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> cadapterView, View view, int position, long l) {
                Object id = clist.get(position).get("id");
                int i = Integer.parseInt(id.toString());
                String image = clist.get(position).get("image").toString();
                String name = clist.get(position).get("name").toString();
                String job = clist.get(position).get("job").toString();
                String sex = clist.get(position).get("sex").toString();
                String birth = clist.get(position).get("birth").toString();
                String death = clist.get(position).get("death").toString();
                String origo = clist.get(position).get("origo").toString();
                String army = clist.get(position).get("army").toString();
                String introduction = clist.get(position).get("introduction").toString();
                String stre = clist.get(position).get("stre").toString();
                String endu = clist.get(position).get("endu").toString();
                String agil = clist.get(position).get("agil").toString();
                String magi = clist.get(position).get("magi").toString();
                String luck = clist.get(position).get("luck").toString();
                String skil = clist.get(position).get("skil").toString();
                Intent intent = new Intent(MainActivity.this, CharacterDetail.class);
                intent.putExtra("id", i)
                        .putExtra("image", image)
                        .putExtra("name", name)
                        .putExtra("job", job)
                        .putExtra("sex", sex)
                        .putExtra("birth", birth)
                        .putExtra("death", death)
                        .putExtra("origo", origo)
                        .putExtra("army", army)
                        .putExtra("introduction", introduction)
                        .putExtra("stre", stre)
                        .putExtra("endu", endu)
                        .putExtra("agil", agil)
                        .putExtra("magi", magi)
                        .putExtra("luck", luck)
                        .putExtra("skil", skil);
                startActivityForResult(intent,0);
            }
        });

        //宝具跳转
        mSkillList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            //            private int id;
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
//                //删除是要拿到当前行的id值才能删除当前行,下面的操作都是点击某个item拿到对应item的id字段
//                //拿到当前position的 item的所有数据
                Object id = slist.get(position).get("id");
                int i = Integer.parseInt(id.toString());
                String owner = slist.get(position).get("owner").toString();
                String type = slist.get(position).get("type").toString();
                String name = slist.get(position).get("name").toString();
                String level = slist.get(position).get("level").toString();
                String introduction = slist.get(position).get("introduction").toString();

                //将得到id传入到需要的方法中
                showSkillDialog(i, owner, type, name, level, introduction);
                return true;
            }
        });

        mSkillList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> cadapterView, View view, int position, long l) {
                Object id = slist.get(position).get("id");
                int i = Integer.parseInt(id.toString());
                String owner = slist.get(position).get("owner").toString();
                String type = slist.get(position).get("type").toString();
                String name = slist.get(position).get("name").toString();
                String level = slist.get(position).get("level").toString();
                String introduction = slist.get(position).get("introduction").toString();
                Intent intent = new Intent(MainActivity.this, SkillDetail.class);
                intent.putExtra("id", i)
                        .putExtra("owner", owner)
                        .putExtra("type", type)
                        .putExtra("name", name)
                        .putExtra("level", level)
                        .putExtra("introduction", introduction);
                startActivityForResult(intent,0);
            }
        });
    }

    /**
     * 点击显示对话框选择修改或者是删除
     */
    private void showCharacterDialog(final int id, final String image, final String name, final String job, final String sex, final String birth, final String death, final String origo, final String army, final String introduction, final  String stre, final String endu, final String agil, final String magi, final String luck, final String skil) {

        mcdialog = new AlertDialog.Builder(MainActivity.this).create();
        mcdialog.show();
        mcdialog.getWindow().setContentView(R.layout.alertdialog);
        mcdialog.getWindow().findViewById(R.id.dia_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CharacterEdit.class);
                intent.putExtra("id", id)
                        .putExtra("image", image)
                        .putExtra("name", name)
                        .putExtra("job", job)
                        .putExtra("sex", sex)
                        .putExtra("birth", birth)
                        .putExtra("death", death)
                        .putExtra("origo", origo)
                        .putExtra("army", army)
                        .putExtra("introduction", introduction)
                        .putExtra("stre", stre)
                        .putExtra("endu", endu)
                        .putExtra("agil", agil)
                        .putExtra("magi", magi)
                        .putExtra("luck", luck)
                        .putExtra("skil", skil);
                startActivityForResult(intent,0);
                mcdialog.dismiss();
            }
        });

        mcdialog.getWindow().findViewById(R.id.dia_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharacterDataBase.getInstances(MainActivity.this).delete(id);
                //重新查询,然后显示
                List<Map<String, Object>> data = getCharacterData("");
                cadapter.refreshList(data);
                Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                mcdialog.dismiss();
            }
        });
        //设置一个标题
        mcdialog.getWindow().findViewById(R.id.dia_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mcdialog.dismiss();
            }
        });
    }

    private void showSkillDialog(final int id, final String owner, final String type, final String name, final String level, final String introduction) {

        msdialog = new AlertDialog.Builder(MainActivity.this).create();
        msdialog.show();
        msdialog.getWindow().setContentView(R.layout.alertdialog);
        msdialog.getWindow().findViewById(R.id.dia_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SkillEdit.class);
                intent.putExtra("id", id)
                        .putExtra("owner", owner)
                        .putExtra("type", type)
                        .putExtra("name", name)
                        .putExtra("level", level)
                        .putExtra("introduction", introduction);
                startActivityForResult(intent,0);
                msdialog.dismiss();
            }
        });

        msdialog.getWindow().findViewById(R.id.dia_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SkillDataBase.getInstances(MainActivity.this).delete(id);
                //重新查询,然后显示
                List<Map<String, Object>> data = getSkillData("");
                sadapter.refreshList(data);
                Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                msdialog.dismiss();
            }
        });
        //设置一个标题
        msdialog.getWindow().findViewById(R.id.dia_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msdialog.dismiss();
            }
        });
    }

    /**
     * 通过查找数据库,拿到里面的数据
     */
    private List<Map<String, Object>> getCharacterData(String s) {
        clist = new ArrayList<>();
        Cursor query = CharacterDataBase.getInstances(MainActivity.this).query();
        /*
        游标cursor默认是在-1的位置,query.moveToFirst()将游标移动到第一行,如果不写这个就会报
         Caused by: android.database.CursorIndexOutOfBoundsException: Index -1 requested, with a size of 12
         这个问题坑爹,以后一定要注意
         */
        if (query.moveToFirst()) {
            do {
                String image = query.getString(query.getColumnIndex("image"));
                String name = query.getString(query.getColumnIndex("name"));
                String job = query.getString(query.getColumnIndex("job"));
                String sex = query.getString(query.getColumnIndex("sex"));
                String birth = query.getString(query.getColumnIndex("birth"));
                String death = query.getString(query.getColumnIndex("death"));
                String origo = query.getString(query.getColumnIndex("origo"));
                String army = query.getString(query.getColumnIndex("army"));
                String introduction = query.getString(query.getColumnIndex("introduction"));
                String stre = query.getString(query.getColumnIndex("stre"));
                String endu = query.getString(query.getColumnIndex("endu"));
                String agil = query.getString(query.getColumnIndex("agil"));
                String magi = query.getString(query.getColumnIndex("magi"));
                String luck = query.getString(query.getColumnIndex("luck"));
                String skil = query.getString(query.getColumnIndex("skil"));
                int id = query.getInt(query.getColumnIndex("id"));
                Map<String, Object> map = new HashMap<>();


                if (s.isEmpty()) {
                    map.put("id", id);
                    map.put("image", image);
                    map.put("name", name);
                    map.put("job", job);
                    map.put("sex", sex);
                    map.put("birth", birth);
                    map.put("death", death);
                    map.put("origo", origo);
                    map.put("army", army);
                    map.put("introduction", introduction);
                    map.put("stre", stre);
                    map.put("endu", endu);
                    map.put("agil", agil);
                    map.put("magi", magi);
                    map.put("luck", luck);
                    map.put("skil", skil);
                    clist.add(map);
                } else {
                    if (name.contains(s)||job.contains(s)||sex.contains(s)||birth.contains(s)||death.contains(s)) {
                        map.put("id", id);
                        map.put("image", image);
                        map.put("name", name);
                        map.put("job", job);
                        map.put("sex", sex);
                        map.put("birth", birth);
                        map.put("death", death);
                        map.put("origo", origo);
                        map.put("army", army);
                        map.put("introduction", introduction);
                        map.put("stre", stre);
                        map.put("endu", endu);
                        map.put("agil", agil);
                        map.put("magi", magi);
                        map.put("luck", luck);
                        map.put("skil", skil);
                        clist.add(map);
                    }
                }

            } while (query.moveToNext());
        }
        //关闭查询游标
        query.close();
        return clist;
    }

    private List<Map<String, Object>> getSkillData(String s) {
        slist = new ArrayList<>();
        Cursor query = SkillDataBase.getInstances(MainActivity.this).query();
        /*
        游标cursor默认是在-1的位置,query.moveToFirst()将游标移动到第一行,如果不写这个就会报
         Caused by: android.database.CursorIndexOutOfBoundsException: Index -1 requested, with a size of 12
         这个问题坑爹,以后一定要注意
         */
        if (query.moveToFirst()) {
            do {
                String owner = query.getString(query.getColumnIndex("owner"));
                String type = query.getString(query.getColumnIndex("type"));
                String name = query.getString(query.getColumnIndex("name"));
                String level = query.getString(query.getColumnIndex("level"));
                String introduction = query.getString(query.getColumnIndex("introduction"));
                int id = query.getInt(query.getColumnIndex("id"));
                Map<String, Object> map = new HashMap<>();


                if (s.isEmpty()) {
                    map.put("id", id);
                    map.put("owner", owner);
                    map.put("type", type);
                    map.put("name", name);
                    map.put("level", level);
                    map.put("introduction", introduction);
                    slist.add(map);
                } else {
                    if (name.contains(s)||level.contains(s)) {
                        map.put("id", id);
                        map.put("owner", owner);
                        map.put("type", type);
                        map.put("name", name);
                        map.put("level", level);
                        map.put("introduction", introduction);
                        slist.add(map);
                    }
                }

            } while (query.moveToNext());
        }
        //关闭查询游标
        query.close();
        return slist;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            List<Map<String, Object>> data1 = getCharacterData("");
            List<Map<String, Object>> data2 = getSkillData("");
//            cadapter = new CharacterListViewAdapter(this, data1);
//            mCharacterList.setAdapter(cadapter);
            cadapter.refreshList(data1);
            sadapter.refreshList(data2);

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //停止并释放资源
        stopService(intent);
    }
}