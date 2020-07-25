package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class ALU extends Wrapper {
    public ALU (String label, String stream, Link... links) {
        super(label, stream, links);
    }
    @Override
    //I considered the first four inputs as inputs Alu Contorl
    //The next 32 bits, ie from index 4 to 35, are the input of the first register
    //The next 32 bits, ie from index 36 to 67, are the input of the second register
    //Input and output is a link...
    // index 0 of output is Ziro

    public void initialize() {
        Not nota = new Not("nota");
        Not notb = new Not("notb");
        Not notc = new Not("notc");
        Not notd = new Not("notd");
        nota.addInput(getInput(0));
        notb.addInput(getInput(1));
        notc.addInput(getInput(2));
        notd.addInput(getInput(3));

        And CAdd= new And("C-add");
        And CSub= new And("C-sub");
        And CAnd= new And("C-and");
        And COr= new And("C-or");
        And CSlt= new And("C-slt");

        CAdd.addInput(nota.getOutput(0),notb.getOutput(0),getInput(2),notd.getOutput(0));
        CSub.addInput(nota.getOutput(0),getInput(1),getInput(2),notd.getOutput(0));
        CAnd.addInput(nota.getOutput(0),notb.getOutput(0),notc.getOutput(0),notd.getOutput(0));
        COr.addInput(nota.getOutput(0),notb.getOutput(0),notc.getOutput(0),getInput(3));
        CSlt.addInput(nota.getOutput(0),getInput(1),getInput(2),getInput(3));

        Adder adder=new Adder("adder","64X33",
                getInput(4),getInput(5),getInput(6),getInput(7),getInput(8),getInput(9),getInput(10),
                getInput(11),getInput(12),getInput(13),getInput(14),getInput(15),getInput(16),getInput(17),
                getInput(18),getInput(19),getInput(20),getInput(21),getInput(22),getInput(23),getInput(24),
                getInput(25),getInput(26),getInput(27),getInput(28),getInput(29),getInput(30),getInput(31),
                getInput(32),getInput(33),getInput(34),getInput(35),getInput(36),getInput(37),getInput(38),
                getInput(39),getInput(40),getInput(41),getInput(42),getInput(43),getInput(44),getInput(45),
                getInput(46),getInput(47),getInput(48),getInput(49),getInput(50),getInput(51),getInput(52),
                getInput(53),getInput(54),getInput(55),getInput(56),getInput(57),getInput(58),getInput(59),
                getInput(60),getInput(61),getInput(62),getInput(63),getInput(64),getInput(65),getInput(66)
                ,getInput(67));
        And carry=new And("carry",adder.getOutput(0),Simulator.trueLogic);

        Link[] inp = new Link[32];
        int i=36;
        for (int j=0; j<32 ; j++){
            inp[j] = getInput(i) ;
            i++;
        }

        TwosComplement tws =new TwosComplement("tws","32X32",inp);

        Adder sub =new Adder("sub","64X33", getInput(4),getInput(5),getInput(6),getInput(7),getInput(8),getInput(9),getInput(10),
                getInput(11),getInput(12),getInput(13),getInput(14),getInput(15),getInput(16),getInput(17),
                getInput(18),getInput(19),getInput(20),getInput(21),getInput(22),getInput(23),getInput(24),
                getInput(25),getInput(26),getInput(27),getInput(28),getInput(29),getInput(30),getInput(31),
                getInput(32),getInput(33),getInput(34),getInput(35),
                tws.getOutput(0),tws.getOutput(1),tws.getOutput(2),tws.getOutput(3),tws.getOutput(4),tws.getOutput(5),
                tws.getOutput(6),tws.getOutput(7),tws.getOutput(8),tws.getOutput(9),tws.getOutput(10),tws.getOutput(11),
                tws.getOutput(12),tws.getOutput(13),tws.getOutput(14),tws.getOutput(15),tws.getOutput(16),tws.getOutput(17),
                tws.getOutput(18),tws.getOutput(19),tws.getOutput(20),tws.getOutput(21),tws.getOutput(22),tws.getOutput(23),
                tws.getOutput(24),tws.getOutput(25),tws.getOutput(26),tws.getOutput(27),tws.getOutput(28),tws.getOutput(29),
                tws.getOutput(30),tws.getOutput(31)
        );

        And and0= new And("and0",getInput(4),getInput(36),CAnd.getOutput(0));
        And and1= new And("and1",getInput(5),getInput(37),CAnd.getOutput(0));
        And and2= new And("and2",getInput(6),getInput(38),CAnd.getOutput(0));
        And and3= new And("and3",getInput(7),getInput(39),CAnd.getOutput(0));
        And and4= new And("and4",getInput(8),getInput(40),CAnd.getOutput(0));
        And and5= new And("and6",getInput(9),getInput(41),CAnd.getOutput(0));
        And and6= new And("and7",getInput(10),getInput(42),CAnd.getOutput(0));
        And and7= new And("and8",getInput(11),getInput(43),CAnd.getOutput(0));
        And and8= new And("and9",getInput(12),getInput(44),CAnd.getOutput(0));
        And and9= new And("and10",getInput(13),getInput(45),CAnd.getOutput(0));
        And and10= new And("and11",getInput(14),getInput(46),CAnd.getOutput(0));
        And and11= new And("and12",getInput(15),getInput(47),CAnd.getOutput(0));
        And and12= new And("and13",getInput(16),getInput(48),CAnd.getOutput(0));
        And and13= new And("and14",getInput(17),getInput(49),CAnd.getOutput(0));
        And and14= new And("and15",getInput(18),getInput(50),CAnd.getOutput(0));
        And and15= new And("and16",getInput(19),getInput(51),CAnd.getOutput(0));
        And and16= new And("and17",getInput(20),getInput(52),CAnd.getOutput(0));
        And and17= new And("and18",getInput(21),getInput(53),CAnd.getOutput(0));
        And and18= new And("and19",getInput(22),getInput(54),CAnd.getOutput(0));
        And and19= new And("and20",getInput(23),getInput(55),CAnd.getOutput(0));
        And and20= new And("and21",getInput(24),getInput(56),CAnd.getOutput(0));
        And and21= new And("and22",getInput(25),getInput(57),CAnd.getOutput(0));
        And and22= new And("and23",getInput(26),getInput(58),CAnd.getOutput(0));
        And and23= new And("and24",getInput(27),getInput(59),CAnd.getOutput(0));
        And and24= new And("and25",getInput(28),getInput(60),CAnd.getOutput(0));
        And and25= new And("and26",getInput(29),getInput(61),CAnd.getOutput(0));
        And and26= new And("and26",getInput(30),getInput(62),CAnd.getOutput(0));
        And and27= new And("and27",getInput(31),getInput(63),CAnd.getOutput(0));
        And and28= new And("and28",getInput(32),getInput(64),CAnd.getOutput(0));
        And and29= new And("and29",getInput(33),getInput(65),CAnd.getOutput(0));
        And and30= new And("and30",getInput(34),getInput(66),CAnd.getOutput(0));
        And and31= new And("and31",getInput(35),getInput(67),CAnd.getOutput(0));

        Or or0= new Or("and0",getInput(4),getInput(36));
        Or or1= new Or("and1",getInput(5),getInput(37));
        Or or2= new Or("and2",getInput(6),getInput(38));
        Or or3= new Or("and3",getInput(7),getInput(39));
        Or or4= new Or("and4",getInput(8),getInput(40));
        Or or5= new Or("and6",getInput(9),getInput(41));
        Or or6= new Or("and7",getInput(10),getInput(42));
        Or or7= new Or("and8",getInput(11),getInput(43));
        Or or8= new Or("and9",getInput(12),getInput(44));
        Or or9= new Or("and10",getInput(13),getInput(45));
        Or or10= new Or("and11",getInput(14),getInput(46));
        Or or11= new Or("and12",getInput(15),getInput(47));
        Or or12= new Or("and13",getInput(16),getInput(48));
        Or or13= new Or("and14",getInput(17),getInput(49));
        Or or14= new Or("and15",getInput(18),getInput(50));
        Or or15= new Or("and16",getInput(19),getInput(51));
        Or or16= new Or("and17",getInput(20),getInput(52));
        Or or17= new Or("and18",getInput(21),getInput(53));
        Or or18= new Or("and19",getInput(22),getInput(54));
        Or or19= new Or("and20",getInput(23),getInput(55));
        Or or20= new Or("and21",getInput(24),getInput(56));
        Or or21= new Or("and22",getInput(25),getInput(57));
        Or or22= new Or("and23",getInput(26),getInput(58));
        Or or23= new Or("and24",getInput(27),getInput(59));
        Or or24= new Or("and25",getInput(28),getInput(60));
        Or or25= new Or("and26",getInput(29),getInput(61));
        Or or26= new Or("and26",getInput(30),getInput(62));
        Or or27= new Or("and27",getInput(31),getInput(63));
        Or or28= new Or("and28",getInput(32),getInput(64));
        Or or29= new Or("and29",getInput(33),getInput(65));
        Or or30= new Or("and30",getInput(34),getInput(66));
        Or or31= new Or("and31",getInput(35),getInput(67));

        And Add1 =new And("radd1",adder.getOutput(1),CAdd.getOutput(0));
        And Add2 =new And("radd2",adder.getOutput(2),CAdd.getOutput(0));
        And Add3 =new And("radd3",adder.getOutput(3),CAdd.getOutput(0));
        And Add4 =new And("radd4",adder.getOutput(4),CAdd.getOutput(0));
        And Add5 =new And("radd5",adder.getOutput(5),CAdd.getOutput(0));
        And Add6 =new And("radd6",adder.getOutput(6),CAdd.getOutput(0));
        And Add7 =new And("radd7",adder.getOutput(7),CAdd.getOutput(0));
        And Add8 =new And("radd8",adder.getOutput(8),CAdd.getOutput(0));
        And Add9 =new And("radd9",adder.getOutput(9),CAdd.getOutput(0));
        And Add10 =new And("radd10",adder.getOutput(10),CAdd.getOutput(0));
        And Add11 =new And("radd11",adder.getOutput(11),CAdd.getOutput(0));
        And Add12 =new And("radd12",adder.getOutput(12),CAdd.getOutput(0));
        And Add13 =new And("radd13",adder.getOutput(13),CAdd.getOutput(0));
        And Add14 =new And("radd14",adder.getOutput(14),CAdd.getOutput(0));
        And Add15 =new And("radd15",adder.getOutput(15),CAdd.getOutput(0));
        And Add16 =new And("radd16",adder.getOutput(16),CAdd.getOutput(0));
        And Add17 =new And("radd17",adder.getOutput(17),CAdd.getOutput(0));
        And Add18 =new And("radd18",adder.getOutput(18),CAdd.getOutput(0));
        And Add19 =new And("radd19",adder.getOutput(19),CAdd.getOutput(0));
        And Add20 =new And("radd20",adder.getOutput(20),CAdd.getOutput(0));
        And Add21 =new And("radd21",adder.getOutput(21),CAdd.getOutput(0));
        And Add22 =new And("radd22",adder.getOutput(22),CAdd.getOutput(0));
        And Add23 =new And("radd23",adder.getOutput(23),CAdd.getOutput(0));
        And Add24 =new And("radd24",adder.getOutput(24),CAdd.getOutput(0));
        And Add25 =new And("radd25",adder.getOutput(25),CAdd.getOutput(0));
        And Add26 =new And("radd26",adder.getOutput(26),CAdd.getOutput(0));
        And Add27 =new And("radd27",adder.getOutput(27),CAdd.getOutput(0));
        And Add28 =new And("radd28",adder.getOutput(28),CAdd.getOutput(0));
        And Add29 =new And("radd29",adder.getOutput(29),CAdd.getOutput(0));
        And Add30 =new And("radd30",adder.getOutput(30),CAdd.getOutput(0));
        And Add31 =new And("radd31",adder.getOutput(31),CAdd.getOutput(0));
        And Add32 =new And("radd32",adder.getOutput(32),CAdd.getOutput(0));


        And Sub1 =new And("sub0",CSub.getOutput(0),sub.getOutput(1));
        And Sub2 =new And("sub1",CSub.getOutput(0),sub.getOutput(2));
        And Sub3 =new And("sub2",CSub.getOutput(0),sub.getOutput(3));
        And Sub4 =new And("sub3",CSub.getOutput(0),sub.getOutput(4));
        And Sub5 =new And("sub4",CSub.getOutput(0),sub.getOutput(5));
        And Sub6 =new And("sub5",CSub.getOutput(0),sub.getOutput(6));
        And Sub7 =new And("sub6",CSub.getOutput(0),sub.getOutput(7));
        And Sub8 =new And("sub7",CSub.getOutput(0),sub.getOutput(8));
        And Sub9 =new And("sub8",CSub.getOutput(0),sub.getOutput(9));
        And Sub10 =new And("sub9",CSub.getOutput(0),sub.getOutput(10));
        And Sub11 =new And("sub10",CSub.getOutput(0),sub.getOutput(11));
        And Sub12 =new And("sub11",CSub.getOutput(0),sub.getOutput(12));
        And Sub13 =new And("sub12",CSub.getOutput(0),sub.getOutput(13));
        And Sub14 =new And("sub13",CSub.getOutput(0),sub.getOutput(14));
        And Sub15 =new And("sub14",CSub.getOutput(0),sub.getOutput(15));
        And Sub16 =new And("sub15",CSub.getOutput(0),sub.getOutput(16));
        And Sub17 =new And("sub16",CSub.getOutput(0),sub.getOutput(17));
        And Sub18 =new And("sub17",CSub.getOutput(0),sub.getOutput(18));
        And Sub19 =new And("sub18",CSub.getOutput(0),sub.getOutput(19));
        And Sub20 =new And("sub19",CSub.getOutput(0),sub.getOutput(20));
        And Sub21 =new And("sub20",CSub.getOutput(0),sub.getOutput(21));
        And Sub22 =new And("sub21",CSub.getOutput(0),sub.getOutput(22));
        And Sub23 =new And("sub22",CSub.getOutput(0),sub.getOutput(23));
        And Sub24 =new And("sub23",CSub.getOutput(0),sub.getOutput(24));
        And Sub25 =new And("sub24",CSub.getOutput(0),sub.getOutput(25));
        And Sub26 =new And("sub25",CSub.getOutput(0),sub.getOutput(26));
        And Sub27 =new And("sub26",CSub.getOutput(0),sub.getOutput(27));
        And Sub28 =new And("sub27",CSub.getOutput(0),sub.getOutput(28));
        And Sub29 =new And("sub28",CSub.getOutput(0),sub.getOutput(29));
        And Sub30 =new And("sub29",CSub.getOutput(0),sub.getOutput(30));
        And Sub31 =new And("sub30",CSub.getOutput(0),sub.getOutput(31));
        And Sub32 =new And("sub31",CSub.getOutput(0),sub.getOutput(32));

        And Or1= new And("or0",COr.getOutput(0),or0.getOutput(0));
        And Or2= new And("or1",COr.getOutput(0),or1.getOutput(0));
        And Or3= new And("or2",COr.getOutput(0),or2.getOutput(0));
        And Or4= new And("or3",COr.getOutput(0),or3.getOutput(0));
        And Or5= new And("or4",COr.getOutput(0),or4.getOutput(0));
        And Or6= new And("or5",COr.getOutput(0),or5.getOutput(0));
        And Or7= new And("or6",COr.getOutput(0),or6.getOutput(0));
        And Or8= new And("or7",COr.getOutput(0),or7.getOutput(0));
        And Or9= new And("or8",COr.getOutput(0),or8.getOutput(0));
        And Or10= new And("or9",COr.getOutput(0),or9.getOutput(0));
        And Or11= new And("or10",COr.getOutput(0),or10.getOutput(0));
        And Or12= new And("or11",COr.getOutput(0),or11.getOutput(0));
        And Or13= new And("or12",COr.getOutput(0),or12.getOutput(0));
        And Or14= new And("or13",COr.getOutput(0),or13.getOutput(0));
        And Or15= new And("or14",COr.getOutput(0),or14.getOutput(0));
        And Or16= new And("or15",COr.getOutput(0),or15.getOutput(0));
        And Or17= new And("or16",COr.getOutput(0),or16.getOutput(0));
        And Or18= new And("or17",COr.getOutput(0),or17.getOutput(0));
        And Or19= new And("or18",COr.getOutput(0),or18.getOutput(0));
        And Or20= new And("or19",COr.getOutput(0),or19.getOutput(0));
        And Or21= new And("or20",COr.getOutput(0),or20.getOutput(0));
        And Or22= new And("or21",COr.getOutput(0),or21.getOutput(0));
        And Or23= new And("or22",COr.getOutput(0),or22.getOutput(0));
        And Or24= new And("or23",COr.getOutput(0),or23.getOutput(0));
        And Or25= new And("or24",COr.getOutput(0),or24.getOutput(0));
        And Or26= new And("or25",COr.getOutput(0),or25.getOutput(0));
        And Or27= new And("or26",COr.getOutput(0),or26.getOutput(0));
        And Or28= new And("or27",COr.getOutput(0),or27.getOutput(0));
        And Or29= new And("or28",COr.getOutput(0),or28.getOutput(0));
        And Or30= new And("or29",COr.getOutput(0),or29.getOutput(0));
        And Or31= new And("or30",COr.getOutput(0),or30.getOutput(0));
        And Or32= new And("or31",COr.getOutput(0),or31.getOutput(0));

        Not notx0=new Not("notx0"
                ,
                getInput(4),getInput(5),getInput(6),getInput(7),getInput(8),getInput(9),getInput(10),
                getInput(11),getInput(12),getInput(13),getInput(14),getInput(15),getInput(16),getInput(17),
                getInput(18),getInput(19),getInput(20),getInput(21),getInput(22),getInput(23),getInput(24),
                getInput(25),getInput(26),getInput(27),getInput(28),getInput(29),getInput(30),getInput(31),
                getInput(32),getInput(33),getInput(34),getInput(35));

        And slt1=new And("slt1",notx0.getOutput(0),getInput(36));
        And slt2=new And("slt2",notx0.getOutput(1),getInput(37));
        And slt3=new And("slt3",notx0.getOutput(2),getInput(38));
        And slt4=new And("slt4",notx0.getOutput(3),getInput(39));
        And slt5=new And("slt5",notx0.getOutput(4),getInput(40));
        And slt6=new And("slt6",notx0.getOutput(5),getInput(41));
        And slt7=new And("slt7",notx0.getOutput(6),getInput(42));
        And slt8=new And("slt8",notx0.getOutput(7),getInput(43));
        And slt9=new And("slt9",notx0.getOutput(8),getInput(44));
        And slt10=new And("slt10",notx0.getOutput(9),getInput(45));
        And slt11=new And("slt11",notx0.getOutput(10),getInput(46));
        And slt12=new And("slt12",notx0.getOutput(11),getInput(47));
        And slt13=new And("slt13",notx0.getOutput(12),getInput(48));
        And slt14=new And("slt14",notx0.getOutput(13),getInput(49));
        And slt15=new And("slt15",notx0.getOutput(14),getInput(50));
        And slt16=new And("slt16",notx0.getOutput(15),getInput(51));
        And slt17=new And("slt17",notx0.getOutput(16),getInput(52));
        And slt18=new And("slt18",notx0.getOutput(17),getInput(53));
        And slt19=new And("slt19",notx0.getOutput(18),getInput(54));
        And slt20=new And("slt20",notx0.getOutput(19),getInput(55));
        And slt21=new And("slt21",notx0.getOutput(20),getInput(56));
        And slt22=new And("slt22",notx0.getOutput(21),getInput(57));
        And slt23=new And("slt23",notx0.getOutput(22),getInput(58));
        And slt24=new And("slt24",notx0.getOutput(23),getInput(59));
        And slt25=new And("slt25",notx0.getOutput(24),getInput(60));
        And slt26=new And("slt26",notx0.getOutput(25),getInput(61));
        And slt27=new And("slt27",notx0.getOutput(26),getInput(62));
        And slt28=new And("slt28",notx0.getOutput(27),getInput(63));
        And slt29=new And("slt29",notx0.getOutput(28),getInput(64));
        And slt30=new And("slt30",notx0.getOutput(29),getInput(65));
        And slt31=new And("slt31",notx0.getOutput(30),getInput(66));
        And slt32=new And("slt32",notx0.getOutput(31),getInput(67));

        Or Sltrez=new Or("Sltrez",
                slt1.getOutput(0),slt2.getOutput(0),slt3.getOutput(0),slt4.getOutput(0),slt5.getOutput(0),
                slt6.getOutput(0),slt7.getOutput(0),slt8.getOutput(0),slt9.getOutput(0),slt10.getOutput(0),
                slt11.getOutput(0),slt12.getOutput(0),slt13.getOutput(0),slt14.getOutput(0),slt15.getOutput(0),
                slt16.getOutput(0),slt17.getOutput(0),slt18.getOutput(0),slt19.getOutput(0),slt20.getOutput(0),
                slt21.getOutput(0),slt22.getOutput(0),slt23.getOutput(0),slt24.getOutput(0),slt25.getOutput(0),
                slt26.getOutput(0),slt27.getOutput(0),slt28.getOutput(0),slt29.getOutput(0),slt30.getOutput(0),
                slt31.getOutput(0),slt32.getOutput(0));
        And Sltresult= new And("rezult",CSlt.getOutput(0),Sltrez.getOutput(0));

        Or r1=new Or("r1",Add1.getOutput(0),and0.getOutput(0),Or1.getOutput(0),Sub1.getOutput(0));
        Or r2=new Or("r2",Add2.getOutput(0),and1.getOutput(0),Or2.getOutput(0),Sub2.getOutput(0));
        Or r3=new Or("r3",Add3.getOutput(0),and2.getOutput(0),Or3.getOutput(0),Sub3.getOutput(0));
        Or r4=new Or("r4",Add4.getOutput(0),and3.getOutput(0),Or4.getOutput(0),Sub4.getOutput(0));
        Or r5=new Or("r5",Add5.getOutput(0),and4.getOutput(0),Or5.getOutput(0),Sub5.getOutput(0));
        Or r6=new Or("r6",Add6.getOutput(0),and5.getOutput(0),Or6.getOutput(0),Sub6.getOutput(0));
        Or r7=new Or("r7",Add7.getOutput(0),and6.getOutput(0),Or7.getOutput(0),Sub7.getOutput(0));
        Or r8=new Or("r8",Add8.getOutput(0),and7.getOutput(0),Or8.getOutput(0),Sub8.getOutput(0));
        Or r9=new Or("r9",Add9.getOutput(0),and8.getOutput(0),Or9.getOutput(0),Sub9.getOutput(0));
        Or r10=new Or("r10",Add10.getOutput(0),and9.getOutput(0),Or10.getOutput(0),Sub10.getOutput(0));
        Or r11=new Or("r11",Add11.getOutput(0),and10.getOutput(0),Or11.getOutput(0),Sub11.getOutput(0));
        Or r12=new Or("r12",Add12.getOutput(0),and11.getOutput(0),Or12.getOutput(0),Sub12.getOutput(0));
        Or r13=new Or("r13",Add13.getOutput(0),and12.getOutput(0),Or13.getOutput(0),Sub13.getOutput(0));
        Or r14=new Or("r14",Add14.getOutput(0),and13.getOutput(0),Or14.getOutput(0),Sub14.getOutput(0));
        Or r15=new Or("r15",Add15.getOutput(0),and14.getOutput(0),Or15.getOutput(0),Sub15.getOutput(0));
        Or r16=new Or("r16",Add16.getOutput(0),and15.getOutput(0),Or16.getOutput(0),Sub16.getOutput(0));
        Or r17=new Or("r17",Add17.getOutput(0),and16.getOutput(0),Or17.getOutput(0),Sub17.getOutput(0));
        Or r18=new Or("r18",Add18.getOutput(0),and17.getOutput(0),Or18.getOutput(0),Sub18.getOutput(0));
        Or r19=new Or("r19",Add19.getOutput(0),and18.getOutput(0),Or19.getOutput(0),Sub19.getOutput(0));
        Or r20=new Or("r20",Add20.getOutput(0),and19.getOutput(0),Or20.getOutput(0),Sub20.getOutput(0));
        Or r21=new Or("r21",Add21.getOutput(0),and20.getOutput(0),Or21.getOutput(0),Sub21.getOutput(0));
        Or r22=new Or("r22",Add22.getOutput(0),and21.getOutput(0),Or22.getOutput(0),Sub22.getOutput(0));
        Or r23=new Or("r23",Add23.getOutput(0),and22.getOutput(0),Or23.getOutput(0),Sub23.getOutput(0));
        Or r24=new Or("r24",Add24.getOutput(0),and23.getOutput(0),Or24.getOutput(0),Sub24.getOutput(0));
        Or r25=new Or("r25",Add25.getOutput(0),and24.getOutput(0),Or25.getOutput(0),Sub25.getOutput(0));
        Or r26=new Or("r26",Add26.getOutput(0),and25.getOutput(0),Or26.getOutput(0),Sub26.getOutput(0));
        Or r27=new Or("r27",Add27.getOutput(0),and26.getOutput(0),Or27.getOutput(0),Sub27.getOutput(0));
        Or r28=new Or("r28",Add28.getOutput(0),and27.getOutput(0),Or28.getOutput(0),Sub28.getOutput(0));
        Or r29=new Or("r29",Add29.getOutput(0),and28.getOutput(0),Or29.getOutput(0),Sub29.getOutput(0));
        Or r30=new Or("r30",Add30.getOutput(0),and29.getOutput(0),Or30.getOutput(0),Sub30.getOutput(0));
        Or r31=new Or("r31",Add31.getOutput(0),and30.getOutput(0),Or31.getOutput(0),Sub31.getOutput(0));
        Or r32=new Or("r32",Add32.getOutput(0),and31.getOutput(0),Or32.getOutput(0),Sub32.getOutput(0),Sltresult.getOutput(0));



        Or zerot=new Or("orzerot",
                r1.getOutput(0),r2.getOutput(0),r3.getOutput(0),r4.getOutput(0),r5.getOutput(0),r6.getOutput(0),
                r7.getOutput(0),r8.getOutput(0),r9.getOutput(0),r10.getOutput(0),r11.getOutput(0),r12.getOutput(0),
                r13.getOutput(0),r14.getOutput(0),r15.getOutput(0),r16.getOutput(0),r17.getOutput(0),r18.getOutput(0),
                r19.getOutput(0),r20.getOutput(0),r21.getOutput(0),r22.getOutput(0),r23.getOutput(0),r25.getOutput(0),
                r26.getOutput(0),r27.getOutput(0),r28.getOutput(0),r29.getOutput(0),r30.getOutput(0),r31.getOutput(0),
                r32.getOutput(0),r24.getOutput(0));
        Not zero=new Not("zero",zerot.getOutput(0));
        addOutput(zero.getOutput(0),r1.getOutput(0),r2.getOutput(0),r3.getOutput(0),r4.getOutput(0),r5.getOutput(0),r6.getOutput(0),
                r7.getOutput(0),r8.getOutput(0),r9.getOutput(0),r10.getOutput(0),r11.getOutput(0),r12.getOutput(0),
                r13.getOutput(0),r14.getOutput(0),r15.getOutput(0),r16.getOutput(0),r17.getOutput(0),r18.getOutput(0),
                r19.getOutput(0),r20.getOutput(0),r21.getOutput(0),r22.getOutput(0),r23.getOutput(0),r24.getOutput(0),
                r25.getOutput(0), r26.getOutput(0),r27.getOutput(0),r28.getOutput(0),r29.getOutput(0),r30.getOutput(0),
                r31.getOutput(0),
                r32.getOutput(0));

    }
}