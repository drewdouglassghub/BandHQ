package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Band;
import model.Musician;

/**
 * Servlet implementation class EditMemberServlet
 */
@WebServlet("/EditMusicianServlet")
public class EditMusicianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMusicianServlet() {
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
		MusicianHelper dao = new MusicianHelper();
		String first = request.getParameter("firstName");
		String last = request.getParameter("lastName");
		String instrument = request.getParameter("instrument");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Musician musicianToUpdate = dao.searchForMusicianById(tempId);
		musicianToUpdate.setFirstName(first);
		musicianToUpdate.setLastName(last);
		musicianToUpdate.setInstrument(instrument);
		dao.updateMusician(musicianToUpdate);
		getServletContext().getRequestDispatcher("/ViewAllMusiciansServlet").forward(request, response);
	}

}
