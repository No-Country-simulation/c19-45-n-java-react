"use client"

import { useForm } from "react-hook-form";


export default function ViewpetsLogin() {


  const { register, handleSubmit } = useForm();

  const onSubmit = handleSubmit ((data) => {
    console.log(data); //en data tiene todos los datos del formulario
  });
  
    return (
      <div className="bg-orange-200 flex min-h-screen items-center justify-center px-6 py-12 lg:px-8">
        <div className="sm:mx-auto sm:w-full sm:max-w-md text-center">
          <h2 className="text-6xl font-bold leading-9 tracking-tight text-gray-900 mb-10">
            Inicio de Sesión
          </h2>
          <a href="#" className="block w-full underline text-xl text-black mb-4">Olvide mi contraseña</a>
  
          <form onSubmit={onSubmit} action="#" method="POST" className="space-y-6">
            <div>
              <div className="flex items-center justify-between">
                <label htmlFor="email" className="block text-2xl font-semibold leading-6 text-black">
                  Correo Electronico:
                </label>
              </div>
              <div className="mt-2">
                <input
                  id="email"
                  type="email"
                  required
                  autoComplete="email"
                  placeholder="   Ingresar correo"
                  className="block w-full rounded-md border-0 py-3 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                  {...register("email")}
                />
              </div>
            </div>
  
            <div>
              <div className="flex items-center justify-between">
                <label htmlFor="password" className="block text-2xl font-semibold leading-6 text-black">
                  Contraseña:
                </label>
              </div>
              <div className="mt-2">
                <input
                  id="password"
                  type="password"
                  required
                  autoComplete="current-password"
                  placeholder="   Ingresar su contraseña"
                  className="block w-full rounded-md border-0 py-3 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                  {...register("password")}
                />
              </div>
            </div>
  
            <div>
              <button  type="submit" className="btn btn-primary bg-black text-xl m-3 hover:bg-gray-600 w-52">
                Ingresar
              </button>
            </div>
          </form>
          <a href="#" className="block w-full underline text-xl text-black mt-4">Registrarme</a>
        </div>
      </div>
    );
  }
  