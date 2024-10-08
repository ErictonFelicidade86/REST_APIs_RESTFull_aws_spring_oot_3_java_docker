package br.am.ericton.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.am.ericton.converters.NumberConverter;
import br.am.ericton.math.SimpleMath;
import br.am.ericton.exceptions.UnsupportedMathOperationException;

@RestController

public class MathController {

	private final AtomicLong counter = new AtomicLong();
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
		) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.sum( NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
		) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.subtraction( NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

	}
	
	@RequestMapping(value = "/multplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double Multiplication(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
		) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.Multiplication( NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double Mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
		) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.Mean( NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo) /2);

	}
	
	@RequestMapping(value = "/squareRoot/{number}", method=RequestMethod.GET)
	public Double SquareRoot(
			@PathVariable(value = "number") String number
		) throws Exception {
		
		if(!NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.squareRoot(NumberConverter.convertToDouble(number));
	}

}
