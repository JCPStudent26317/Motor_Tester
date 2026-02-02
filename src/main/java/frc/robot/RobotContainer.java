package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.TalonFXMotor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  private final TalonFXMotor motor = new TalonFXMotor(0);

  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    motor.setDefaultCommand(motor.setOutput(() -> m_driverController.getLeftY() * -1));
  }

  public Command getAutonomousCommand() {
    return Commands.print("Doing nothing");
  }
}
