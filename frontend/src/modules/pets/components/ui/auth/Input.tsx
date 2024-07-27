import React from 'react';
import { UseFormRegister } from 'react-hook-form';

interface Props extends React.InputHTMLAttributes<HTMLInputElement> {
  register: UseFormRegister<any>;
  name: string;
}

export function Input({ register, name, ...props }: Props) {
  return (
    <input
      {...register(name)}
      className="block w-full rounded-md border-0 py-3 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300
        placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6 px-3"
      {...props}
    />
  );
}

