package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.SparkMaxBrushlessMotor;
import frc.robot.subsystems.TalonFXMotor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  private final TalonFXMotor intake = new TalonFXMotor(43);
  private final TalonFXMotor magazineBottom = new TalonFXMotor(40); 
  private final TalonFXMotor magazineTop = new TalonFXMotor(42); 
  private final TalonFXMotor hopperTop = new TalonFXMotor(41);
  private final TalonFXMotor hopperBottom = new TalonFXMotor(44);
  private final TalonFXMotor shooter1 = new TalonFXMotor(50);
  private final TalonFXMotor shooter2 = new TalonFXMotor(51);

  private final SparkMaxBrushlessMotor climber = new SparkMaxBrushlessMotor(4);

  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    // intake.setDefaultCommand(intake.setOutput(() -> m_driverController.getLeftY() * -1 * -0.66));
    
    // magazineBottom.setDefaultCommand(magazineBottom.setOutput(() -> m_driverController.getRightY() * -1 * -0.66));
    // magazineTop.setDefaultCommand(magazineTop.setOutput(() -> m_driverController.getRightY() * -1 * -0.66));
    // hopperTop.setDefaultCommand(hopperTop.setOutput(() -> m_driverController.getRightY() * -1 * 0.66));
    // hopperBottom.setDefaultCommand(hopperBottom.setOutput(() -> m_driverController.getRightY() * -1 * 0.66));

    // shooter1.setDefaultCommand(shooter1.setOutput(() -> m_driverController.getRightTriggerAxis() * -1));
    // shooter2.setDefaultCommand(shooter2.setOutput(() -> m_driverController.getRightTriggerAxis() * 1));

    climber.setDefaultCommand(climber.setOutput(() -> m_driverController.getLeftY() * -1 * -1));
  }

  public Command getAutonomousCommand() {
    return Commands.print("Doing nothing");
  }
}
