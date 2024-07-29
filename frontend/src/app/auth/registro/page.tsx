import { FormBasic, Input, InputPassword, STEP_FORM, StepsForm } from "@/app/_components";
import Link from "next/link";

const PageRegister = () => {
  return (
    <section className="flex justify-center flex-col items-center my-12">
      <div className="flex flex-col gap-3 text-center">
        <h1 className="text-6xl font-bold">Crear Cuenta</h1>
        <Link
          href="/auth/inicio-sesion"
          className="text-3xl underline font-semibold"
        >
          Ya tengo una cuenta
        </Link>
      </div>

      <StepsForm currentStep={STEP_FORM.BASIC} />

      <div className="w-[700px] mt-8 flex flex-col gap-6">
        <FormBasic />
        <div className="mt-4 flex flex-col items-center gap-4">
          <button
            type="button"
            className="btn btn-active text-white btn-lg w-56 shadow-lg text-2xl"
          >
            <p>Siguiente</p>
          </button>
        </div>
      </div>
    </section>
  );
};

export default PageRegister;
