"use client";

import { useState } from "react";
import { FaEye, FaEyeSlash } from "react-icons/fa";

interface IInputPassword {
  label: string;
  placeholder: string;
  value?: string;
}

export const InputPassword = ({
  label,
  placeholder,
  value,
}: IInputPassword) => {
  const [showPassword, setShowPassword] = useState(false);

  const toggleShowPassword = () => {
    setShowPassword(!showPassword);
  };
  return (
    <div>
      <p className="text-2xl font-medium mb-2">{label}:</p>
      <div className="relative">
        <input
          type={showPassword ? "text" : "password"}
          className="bg-white p-5 w-full rounded-lg shadow-md"
          placeholder={placeholder}
          value={value}
        />
        <span
          className="absolute right-4 top-4 cursor-pointer"
          onClick={toggleShowPassword}
        >
          {showPassword ? <FaEyeSlash size={30} /> : <FaEye size={30} />}
        </span>
      </div>
    </div>
  );
};
