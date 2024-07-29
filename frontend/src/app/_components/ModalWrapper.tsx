"use client";

import { IoCloseCircle } from "react-icons/io5";
import { useModalStore } from "@/app/_store";

interface ModalProps {
  title?: string;
  subtitle?: string;
  children: React.ReactNode;
  name?: string;
}

export const ModalWrapper = ({
  title,
  children,
  name,
  subtitle,
}: ModalProps) => {
  const toggle = useModalStore((state) => state.toggle);
  const modalName = useModalStore((state) => state.name);
  const isOpen = useModalStore((state) => state.isOpen);

  if (modalName === name && isOpen) {
    return (
      <div className="fixed z-50 inset-0 flex items-center justify-center overflow-hidden">
        <div className="fixed inset-0 transition-opacity">
          <div className="absolute inset-0 bg-gray-900 opacity-75"></div>
        </div>

        <div className="rounded-xl text-left overflow-hidden shadow-xl transform transition-all ">
          <div className="bg-[#FFAC31] px-8 py-4 flex flex-col gap-8">
            <div className="ml-auto">
              <IoCloseCircle
                color="#000"
                className="cursor-pointer"
                size={50}
                onClick={() => toggle({ isOpen: false, name: "" })}
              />
            </div>
            {title && (
              <div className={`${!subtitle ? "mb-4" : ""} text-center`}>
                <h3 className="text-5xl leading-6 font-bold cfc-text-purple-300">
                  {title}
                </h3>
                {subtitle && (
                  <p className="mb-4 mt-5 text-2xl font-bold text-black">
                    {subtitle}
                  </p>
                )}
              </div>
            )}

            <div className="mx-4 mb-8">{children}</div>
          </div>
        </div>
      </div>
    );
  }
};
