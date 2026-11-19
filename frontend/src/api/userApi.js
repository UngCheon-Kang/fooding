import axios from 'axios';

const BASE_URL = "http://localhost:8080/api/users";

export const createUser = async (user) => {
  const res = await axios.post(BASE_URL, user);
  return res.data;
};
