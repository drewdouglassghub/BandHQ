package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Band;
import model.Musician;

/**
 * Servlet implementation class AddMusicianServlet
 */
@WebServlet("/AddMusicianServlet")
public class AddMusicianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMusicianServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String first = request.getParameter("firstName");
		String last = request.getParameter("lastName");
		String instrument = request.getParameter("instrument");
		String band = request.getParameter("bandName");
		BandHelper bh = new BandHelper();
		List<Band> bandList  = bh.showAllBands();
		int temp = 0;
		for(int i = 0; i < bandList.size(); i++) {
			if(bandList.get(i).getBandName().equals(band)) {
				temp = i;			
			}
		}
		
		Musician m = new Musician(first, last, instrument, bandList.get(temp));
		MusicianHelper dao = new MusicianHelper();
		dao.insertMusician(m);
		getServletContext().getRequestDispatcher("/ViewAllMusiciansServlet").forward(request, response);
	}

}
