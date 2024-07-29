"use client";

import {
  FormBasic,
  FormContact,
  STEP_FORM,
  StepsForm,
} from "@/app/_components";
import Link from "next/link";
import { useState } from "react";

const PageRegister = () => {
  const [step, setStep] = useState(STEP_FORM.BASIC);

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

      <StepsForm currentStep={step} />

      <div className="w-[700px] mt-8 flex flex-col gap-6">
        {STEP_FORM.BASIC === step && <FormBasic />}
        {STEP_FORM.CONTACT === step && <FormContact />}
        <div className="mt-4 flex flex-col items-center gap-4">
          {STEP_FORM.BASIC === step && (
            <button
              type="button"
              className="btn btn-active text-white btn-lg w-56 shadow-lg text-2xl"
              onClick={() => setStep(STEP_FORM.CONTACT)}
            >
              <p>Siguiente</p>
            </button>
          )}
          {STEP_FORM.CONTACT === step && (
            <div className="flex gap-4">
              <button
                type="button"
                className="hover:bg-transparent hover:border-black btn btn-outline border-black border-2 text-black btn-lg w-56 shadow-lg text-2xl"
                onClick={() => setStep(STEP_FORM.BASIC)}
              >
                <p>Regresar</p>
              </button>
              <button
                type="button"
                className="btn btn-active text-white btn-lg w-56 shadow-lg text-2xl"
              >
                <p>Registrarme</p>
              </button>
            </div>
          )}
        </div>
      </div>
    </section>
  );
};

export default PageRegister;
