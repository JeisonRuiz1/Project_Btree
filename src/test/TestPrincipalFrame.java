package test;

import view.FramePrincipal;

public class TestPrincipalFrame {

		public static void main(String[] args) {
			FramePrincipal frame = new FramePrincipal();
			frame.init();
			frame.animImage();
			frame.initAnimationCharge(10);
		}
}
