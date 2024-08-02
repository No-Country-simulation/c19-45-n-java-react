import Link from "next/link";
import { Input, InputPassword } from "@/components";

const PageLogin = () => {
  return (
    <section className="flex justify-center flex-col items-center my-12">
      <div className="flex flex-col gap-3 text-center">
        <h1 className="text-6xl font-bold">Inicio de Sesión</h1>
        <Link href="/" className="text-3xl underline font-semibold">
          Olvidé mi contraseña{" "}
        </Link>
      </div>

      <div className="w-[700px] mt-8 flex flex-col gap-6">
        <Input
          label="Correo electrónico"
          type="email"
          placeholder="Ingresar correo"
        />
        <InputPassword label="Contraseña" placeholder="Ingrese su contraseña" />

        <div className="mt-4 flex flex-col items-center gap-4">
          <Link
            href="/dashboard/mascotas"
            type="button"
            className="btn btn-active text-white btn-lg w-56 shadow-lg text-2xl"
          >
            <p>Ingresar</p>
          </Link>
          <Link
            href="/auth/registro"
            className="underline font-medium text-3xl"
          >
            Registrarme
          </Link>
        </div>
      </div>
    </section>
  );
};

export default PageLogin;
