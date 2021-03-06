package com.vansl.rtdata;


class OperandStackTest {

    @org.junit.jupiter.api.Test
    void testOperandStack() {
        Frame frame = new Frame(new Thread(1024),100,100);
        OperandStack ops = frame.getOperandStack();
        ops.pushInt(100);
        ops.pushInt(-100);
        ops.pushLong(2997924580L);
        ops.pushLong(-2997924580L);
        ops.pushFloat(3.1415926f);
        ops.pushDouble(2.71828182845);
        Object object = new Object();
        ops.pushRef(object);

        assert ops.popRef() == object;
        assert ops.popDouble()-2.71828182845 <= 0.0001;
        assert ops.popFloat()-3.1415926f <= 0.0001;
        assert ops.popLong() == -2997924580L;
        assert ops.popLong() == 2997924580L;
        assert ops.popInt() == -100;
        assert ops.popInt() == 100;
    }

}