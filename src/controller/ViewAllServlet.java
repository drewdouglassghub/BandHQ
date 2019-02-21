package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Band;
import model.Musician;

/**
 * Servlet implementation class ViewAllServlet
 */
@WebServlet("/ViewAllServlet")
public class ViewAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BandHelper dao = new BandHelper();
		request.setAttribute("allBands", dao.showAllBands());
		
		if(dao.showAllBands().isEmpty()){
		request.setAttribute("allBands", " ");		
		
		MusicianHelper mh = new MusicianHelper();
		request.setAttribute("allMusicians", mh.showAllMusicians());
		String bandName = request.getParameter("bandName");
		System.out.println("Band Name: "+ bandName);
		String first = request.getParameter("firstName");
		String last = request.getParameter("lastName");
		String instrument = request.getParameter("instrument");
		String[] selectedMusicians = request.getParameterValues("allMusicians");
		List<Musician> selectedMusiciansInList = new ArrayList<Musician>();
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedMusicians != null && selectedMusicians.length > 0)
		{
		for(int i = 0; i<selectedMusicians.length; i++) {
		System.out.println(selectedMusicians[i].toString());
		Musician m = mh.searchForMusicianById(Integer.parseInt(selectedMusicians[i]));
		selectedMusiciansInList.add(m);
		}
		}
		Band band = new Band(bandName);
		Musician sld = new Musician(first, last, instrument);
		band.setBandMembers(selectedMusiciansInList);
		MusicianHelper omh = new MusicianHelper();
		omh.insertMusician(sld);
		System.out.println("Success!");
		System.out.println(sld.toString());
		}
		getServletContext().getRequestDispatcher("/ViewAllBandsServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
