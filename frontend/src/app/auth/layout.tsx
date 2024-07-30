import { LayoutMain } from "@/layouts";

const LayoutAuth = ({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) => {
  return <LayoutMain>{children}</LayoutMain>;
};

export default LayoutAuth;
