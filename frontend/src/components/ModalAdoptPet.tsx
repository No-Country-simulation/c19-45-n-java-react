import { MODAL } from "@/constants";
import { ModalWrapper } from ".";

export const ModalAdoptPet = () => {
  return (
    <ModalWrapper
      name={MODAL.PET}
      title="Proceso de Adopción"
      subtitle="¡Gracias por tu interés"
    >
      <div className="w-[550px] text-md">
        <p>
          Nuestra misión es facilitar el proceso de adopción, asegurando que
          nuestras mascotas encuentren un hogar seguro.
        </p>
        <p>Sigue estos pasos para completar la adopción:</p>
        <ol className="mt-4 list-decimal list-inside space-y-2 pl-5">
          <li>
            Verifica tu correo electrónico y descarga el formulario de adopción.
          </li>
          <li>Completa el formulario.</li>
          <li>Envía el formulario completado a nuestro correo de contacto.</li>
          <li>
            Nuestro equipo revisará tu solicitud y te responderá en 24 horas.
          </li>
        </ol>
      </div>
    </ModalWrapper>
  );
};
