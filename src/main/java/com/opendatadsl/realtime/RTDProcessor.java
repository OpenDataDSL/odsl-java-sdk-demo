package com.opendatadsl.realtime;

import java.util.function.Consumer;

public class RTDProcessor implements Consumer<Object> {
	@Override
	public void accept(Object t) {
		System.out.println(t.toString());
	}	
}
