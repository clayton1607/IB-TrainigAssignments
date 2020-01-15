package thirdAssign;

class StudentView{
	public void show() {
		System.out.println("StudentView");
	}
}
class HomeView{
	public void show() {
		System.out.println("Home View");
	}
}
class Dispatcher{
	private StudentView sv;
	private HomeView hv;
	public Dispatcher() {
		sv= new StudentView();
		hv= new HomeView();
	}
	public void dispatch(String request) {
		if(request.equals("Student")) {
			sv.show();
		}
		else 
			hv.show();
		
	}
}
class FrontController{
	private Dispatcher dp;
	public FrontController() {
		dp= new Dispatcher();
	}
	public boolean isAuthenticated() {
		return true;
	}
	public void dispatchRequest (String request) {
		if (isAuthenticated()) {
			dp.dispatch(request);
		}
	}
}
public class FrontControllerDessign {
	public static void main(String[] args) {
		FrontController fc = new FrontController();
		fc.dispatchRequest("Student");
		fc.dispatchRequest("Home");
	}
}
