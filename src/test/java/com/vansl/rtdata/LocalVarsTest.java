package com.vansl.rtdata;


import com.vansl.rtdata.heap.Object;

class LocalVarsTest {


    @org.junit.jupiter.api.Test
    void testLocalVars() {
        Frame frame = new Frame(new Thread(1024),100,100);
        LocalVars vars  = frame.getLocalVars();
        vars.setInt(0, 100);
        vars.setInt(1, -100);
        vars.setLong(2, 2997924580L);
        vars.setLong(4, -2997924580L);
        vars.setFloat(6, 3.1415926f);
        vars.setDouble(7, 2.71828182845);
        Object object = new Object();
        vars.setRef(9, object);
        assert vars.getInt(0) == 100;
        assert vars.getInt(1) == -100;
        assert vars.getLong(2) == 2997924580L;
        assert vars.getLong(4) == -2997924580L;
        assert vars.getFloat(6)-3.1415926f <= 0.00001;
        assert vars.getDouble(7)-2.71828182845 <= 0.00001;
        assert vars.getRef(9) == object;
    }

}