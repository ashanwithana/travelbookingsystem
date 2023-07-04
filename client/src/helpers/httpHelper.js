/* eslint-disable no-undef */
import axios from 'axios';
import { TokenExpired } from './logout';

export const GET = async (path) => {
	path = `${process.env.REACT_APP_API_LINK_PREFIX}${path}`;
	try {
		const response = await axios.get(path);
		return response.data;
	} catch (error) {
		if (error.response.status === 403) {
			TokenExpired();
		} else {
			console.log(error);
			return error.response.data;
		}
		return error.response.data;
	}
};

export const POST = async (path, data) => {
	path = `${process.env.REACT_APP_API_LINK_PREFIX}${path}`;
	try {
		const response = await axios.post(path, data);
		return response.data;
	} catch (error) {
		if (error.response.status === 403) {
			TokenExpired();
		} else {
			console.log(error);
			return error.response.data;
		}
		return error.response.data;
	}
};

export const DELETE = async (path, data) => {
	path = `${process.env.REACT_APP_API_LINK_PREFIX}${path}`;
	try {
		const response = await axios.delete(path);
		return response.data;
	} catch (error) {
		if (error.response.status === 403) {
			TokenExpired();
		} else {
			console.log(error);
			return error.response.data;
		}
		return error.response.data;
	}
};

export const PUT = async (path, data) => {
	path = `${process.env.REACT_APP_API_LINK_PREFIX}${path}`;
	try {
		const response = await axios.put(path, data);
		return response.data;
	} catch (error) {
		if (error.response.status === 403) {
			TokenExpired();
		} else {
			console.log(error);
			return error.response.data;
		}
		return error.response.data;
	}
};
