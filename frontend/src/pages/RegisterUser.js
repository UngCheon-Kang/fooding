import React, { useState } from 'react';
import { createUser } from '../api/userApi';

const RegisterUser = () => {
  const [user, setUser] = useState({
    name: '',
    phone: '',
    region: '',
    type: 'PERSONAL'
  });

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await createUser(user);
    alert("회원가입 완료!");
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="name" placeholder="이름" onChange={handleChange} /><br/>
      <input name="phone" placeholder="전화번호" onChange={handleChange} /><br/>
      <input name="region" placeholder="지역" onChange={handleChange} /><br/>
      <select name="type" onChange={handleChange}>
        <option value="PERSONAL">개인</option>
        <option value="BUSINESS">사업자</option>
      </select><br/>
      <button type="submit">회원가입</button>
    </form>
  );
};

export default RegisterUser;
