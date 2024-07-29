import React from "react";
import classNames from "classnames";

export enum STEP_FORM {
  BASIC = "BASIC",
  CONTACT = "CONTACT",
}

interface ISteps {
  currentStep: STEP_FORM;
}

const StepButton = ({
  step,
  label,
  currentStep,
  isFirst,
  isLast,
}: {
  step: STEP_FORM;
  label: string;
  currentStep: STEP_FORM;
  isFirst?: boolean;
  isLast?: boolean;
}) => {
  const isActive = currentStep === step;
  return (
    <button
      type="button"
      className={classNames("btn btn-lg text-2xl border-0", {
        "bg-black text-white": isActive,
        "bg-transparent text-black hover:bg-transparent": !isActive,
        "rounded-l-lg": isFirst,
        "rounded-r-lg": isLast,
      })}
    >
      <p>{label}</p>
    </button>
  );
};

export const StepsForm = ({ currentStep }: ISteps) => {
  return (
    <div className="bg-[#FFCD82] rounded-lg shadow-lg overflow-hidden grid grid-cols-2 mt-8 mb-2">
      <StepButton
        step={STEP_FORM.BASIC}
        label="1. Básico"
        currentStep={currentStep}
        isFirst
      />
      <StepButton
        step={STEP_FORM.CONTACT}
        label="2. Contacto"
        currentStep={currentStep}
        isLast
      />
    </div>
  );
};
