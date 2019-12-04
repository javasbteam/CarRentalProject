 package com.ivl.car.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.ivl.car.model.BookedCar;
import com.ivl.car.model.CarDetailsInput;
import com.ivl.car.model.CarModel;
import com.ivl.car.models.AuthenticationRequest;
import com.ivl.car.models.AuthenticationResponse;
import com.ivl.car.service.CarDetailsService;
import com.ivl.car.service.MyUserDetailsService;
import com.ivl.car.util.JwtUtil;

@RestController
public class CarService1Resource {

	@Autowired
	private CarDetailsService carService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@GetMapping("/*")
	public RedirectView testUrl(HttpServletRequest req, HttpServletResponse res) {
		String token = req.getParameter("token");
		System.out.println("--------------");
		return new RedirectView("http://localhost:9090/api1/searchcar1");

	}

	@PostMapping(value = "/searchcar1")
	public List<CarModel> getCarByType(@RequestBody CarDetailsInput carInput)  {

		List<CarModel> list = carService.searchByCarType(carInput);
		list.forEach(l1 -> l1.setApiAddress("api1"));
		return list;

	}

	@PostMapping(value = "/bookcar1")
	public BookedCar bookCar(@RequestBody BookedCar bookedCar) {

		return carService.bookCar(bookedCar);
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
